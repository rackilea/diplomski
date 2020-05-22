package src;

import java.io.*;
import java.net.URI;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import javax.xml.XMLConstants;

import org.w3c.dom.*;
import org.xml.sax.*;

import org.apache.xml.resolver.tools.CatalogResolver;
import org.apache.xerces.util.XMLCatalogResolver;
import static org.apache.xerces.jaxp.JAXPConstants.JAXP_SCHEMA_LANGUAGE;
import static org.apache.xerces.jaxp.JAXPConstants.W3C_XML_SCHEMA;

import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Download http://xerces.apache.org/xml-commons/components/resolver/CatalogManager.properties
 */
public class TestXSD {
  private final static String ENTITY_RESOLVER =
    "http://apache.org/xml/properties/internal/entity-resolver";

  /**
   * This program reads an XML file, performs validation, reads an XSL
   * file, transforms the input XML, and then writes the transformed document
   * to standard output.
   *
   * args[0] - The XSL file used to transform the XML file
   * args[1] - The XML file to transform using the XSL file
   */
  public static void main( String args[] ) throws Exception {
    // For validation error messages.
    ErrorHandler errorHandler = new DocumentErrorHandler(); 

    // Read the CatalogManager.properties file.
    CatalogResolver resolver = new CatalogResolver();
    XMLCatalogResolver xmlResolver = createXMLCatalogResolver( resolver );

    logDebug( "READ XML INPUT SOURCE" );
    // Load an XML document in preparation to transform it.
    InputSource xmlInput = new InputSource( new InputStreamReader(
      new FileInputStream( args[1] ) ) );

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    dbFactory.setAttribute( JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA );
    dbFactory.setNamespaceAware( true );

    DocumentBuilder builder = dbFactory.newDocumentBuilder();
    builder.setEntityResolver( xmlResolver );
    builder.setErrorHandler( errorHandler );

    logDebug( "PARSE XML INTO DOCUMENT MODEL" );
    Document xmlDocument = builder.parse( xmlInput );

    logDebug( "CONVERT XML DOCUMENT MODEL INTO DOMSOURCE" );
    DOMSource xml = new DOMSource( xmlDocument );

    logDebug( "GET XML SCHEMA DEFINITION" );
    String schemaURI = getSchemaURI( xmlDocument );

    logDebug( "SCHEMA URI: " + schemaURI );

    if( schemaURI != null ) {
      logDebug( "CREATE SCHEMA FACTORY" );
      // Create a Schema factory to obtain a Schema for XML validation...
      SchemaFactory sFactory = SchemaFactory.newInstance( W3C_XML_SCHEMA );
      sFactory.setResourceResolver( xmlResolver );

      logDebug( "CREATE XSD INPUT SOURCE" );
      String xsdFileURI = xmlResolver.resolveURI( schemaURI );

      logDebug( "CREATE INPUT SOURCE XSD FROM: " + xsdFileURI );
      InputSource xsd = new InputSource(
        new FileInputStream( new File( new URI( xsdFileURI ) ) ) );

      logDebug( "CREATE SCHEMA OBJECT FOR XSD" );
      Schema schema = sFactory.newSchema( new SAXSource( xsd ) );

      logDebug( "CREATE VALIDATOR FOR SCHEMA" );
      Validator validator = schema.newValidator();

      logDebug( "VALIDATE XML AGAINST XSD" );
      validator.validate( xml );
    }

    logDebug( "READ XSL INPUT SOURCE" );
    // Load an XSL template for transforming XML documents.
    InputSource xslInput = new InputSource( new InputStreamReader(
      new FileInputStream( args[0] ) ) );

    logDebug( "PARSE XSL INTO DOCUMENT MODEL" );
    Document xslDocument = builder.parse( xslInput );

    transform( xmlDocument, xslDocument, resolver );
    System.out.println();
  }

  private static void transform(
    Document xml, Document xsl, CatalogResolver resolver ) throws Exception
  {
    if( versionAtLeast( xsl, 2 ) ) {
      useXSLT2Transformer();
    }

    logDebug( "CREATE TRANSFORMER FACTORY" );
    // Create the transformer used for the document.
    TransformerFactory tFactory = TransformerFactory.newInstance();
    tFactory.setURIResolver( resolver );

    logDebug( "CREATE TRANSFORMER FROM XSL" );
    Transformer transformer = tFactory.newTransformer( new DOMSource( xsl ) );

    logDebug( "CREATE RESULT OUTPUT STREAM" );
    // This enables writing the results to standard output.
    Result out = new StreamResult( new OutputStreamWriter( System.out ) );

    logDebug( "TRANSFORM THE XML AND WRITE TO STDOUT" );
    // Transform the document using a given stylesheet.
    transformer.transform( new DOMSource( xml ), out );
  }

  /**
   * Answers whether the given XSL document version is greater than or
   * equal to the given required version number.
   *
   * @param xsl The XSL document to check for version compatibility.
   * @param version The version number to compare against.
   *
   * @return true iff the XSL document version is greater than or equal
   * to the version parameter.
   */
  private static boolean versionAtLeast( Document xsl, float version ) {
    Element root = xsl.getDocumentElement();
    float docVersion = Float.parseFloat( root.getAttribute( "version" ) );

    return docVersion >= version;
  }

  /**
   * Enables Saxon9's XSLT2 transformer for XSLT2 files.
   */
  private static void useXSLT2Transformer() {
    System.setProperty("javax.xml.transform.TransformerFactory",
      "net.sf.saxon.TransformerFactoryImpl");
  }

  /**
   * Creates an XMLCatalogResolver based on the file names found in
   * the given CatalogResolver. The resulting XMLCatalogResolver will
   * contain the absolute path to all the files known to the given
   * CatalogResolver.
   *
   * @param resolver The CatalogResolver to examine for catalog file names.
   * @return An XMLCatalogResolver instance with the same number of catalog
   * files as found in the given CatalogResolver.
   */
  private static XMLCatalogResolver createXMLCatalogResolver(
    CatalogResolver resolver ) {
    int index = 0;
    List files = resolver.getCatalog().getCatalogManager().getCatalogFiles();
    String catalogs[] = new String[ files.size() ];
    XMLCatalogResolver xmlResolver = new XMLCatalogResolver();

    for( Object file : files ) {
      catalogs[ index ] = (new File( file.toString() )).getAbsolutePath();
      index++;
    }

    xmlResolver.setCatalogList( catalogs );

    return xmlResolver;
  }

  private static String[] parseNameValue( String nv ) {
    Pattern p = Pattern.compile( "\\s*(\\w+)=\"([^\"]*)\"\\s*" );
    Matcher m = p.matcher( nv );
    String result[] = new String[2];

    if( m.find() ) {
      result[0] = m.group(1);
      result[1] = m.group(2);
    }

    return result;
  }

  /**
   * Retrieves the XML schema definition using an XSD.
   *
   * @param node The document (or child node) to traverse seeking processing
   * instruction nodes.
   * @return null if no XSD is present in the XML document.
   * @throws IOException Never thrown (uses StringReader).
   */
  private static String getSchemaURI( Node node ) throws IOException {
    String result = null;

    if( node.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE ) {
      ProcessingInstruction pi = (ProcessingInstruction)node;

      logDebug( "NODE IS PROCESSING INSTRUCTION" );

      if( "xml-model".equals( pi.getNodeName() ) ) {
        logDebug( "PI IS XML MODEL" );

        // Hack to get the attributes.
        String data = pi.getData();

        if( data != null ) {
          final String attributes[] = pi.getData().trim().split( "\\s+" );

          String type = parseNameValue( attributes[0] )[1];
          String href = parseNameValue( attributes[1] )[1];

          // TODO: Schema should = http://www.w3.org/2001/XMLSchema
          //String schema = attributes.getNamedItem( "schematypens" );

          if( "application/xml".equalsIgnoreCase( type ) && href != null ) {
            result = href;
          }
        }
      }
    }
    else {
      // Try to get the schema type information.
      NamedNodeMap attrs = node.getAttributes();

      if( attrs != null ) {
        // TypeInfo.toString() returns values of the form:
        // schemaLocation="uri schemaURI"
        // The following loop extracts the schema URI.
        for( int i = 0; i < attrs.getLength(); i++ ) {
          Attr attribute = (Attr)attrs.item( i );
          TypeInfo typeInfo = attribute.getSchemaTypeInfo();
          String attr[] = parseNameValue( typeInfo.toString() );

          if( "schemaLocation".equalsIgnoreCase( attr[0] ) ) {
            result = attr[1].split( "\\s" )[1];
            break;
          }
        }
      }

      // Look deeper for the schema URI.
      if( result == null ) {
        NodeList list = node.getChildNodes();

        for( int i = 0; i < list.getLength(); i++ ) {
          result = getSchemaURI( list.item( i ) );

          if( result != null ) {
            break;
          }
        }
      }
    }

    return result;
  }

  /**
   * Writes a message to standard output.
   */
  private static void logDebug( String s ) {
    System.out.println( s );
  }
}