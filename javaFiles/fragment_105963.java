package src;

import java.io.PrintStream;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;

/**
 * Handles error messages during parsing and validating XML documents.
 */
public class DocumentErrorHandler implements ErrorHandler {
  private final static PrintStream OUTSTREAM = System.err;

  private void log( String type, SAXParseException e ) {
    OUTSTREAM.println( "SAX PARSE EXCEPTION " + type );
    OUTSTREAM.println( "  Public ID: " + e.getPublicId() );
    OUTSTREAM.println( "  System ID: " + e.getSystemId() );
    OUTSTREAM.println( "  Line     : " + e.getLineNumber() );
    OUTSTREAM.println( "  Column   : " + e.getColumnNumber() );
    OUTSTREAM.println( "  Message  : " + e.getMessage() );
  }

  @Override
  public void error( SAXParseException e ) throws SAXException {
    log( "ERROR", e );
  }

  @Override
  public void fatalError( SAXParseException e ) throws SAXException {
    log( "FATAL ERROR", e );
  }

  @Override
  public void warning( SAXParseException e ) throws SAXException {
    log( "WARNING", e );
  }
}