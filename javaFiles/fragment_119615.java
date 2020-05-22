import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xsd2inst.SampleXmlUtil;
import org.apache.xmlbeans.impl.xsd2inst.SchemaInstanceGenerator;

import java.util.ArrayList;
import java.util.List;

public class XmlInstanceGeneratorImpl {
  private static final Logger logger = LogManager.getLogger(XmlInstanceGeneratorImpl.class);

  /**
   * Specifies if network downloads are enabled for imports and includes.
   * Default value is {@code false}
   */
  private static final boolean ENABLE_NETWORK_DOWNLOADS = false;

  /**
   * disable particle valid (restriction) rule
   * Default value is {@code false}
   */
  private static final boolean NO_PVR = false;

  /**
   * disable unique particle attribution rule.
   * Default value is {@code false}
   */
  private static final boolean NO_UPA = false;


  public String generateXmlInstance(String xsdAsString, String elementToGenerate){
    return generateXmlInstance(xsdAsString, elementToGenerate, ENABLE_NETWORK_DOWNLOADS, NO_PVR, NO_UPA);
  }


  public String generateXmlInstance(String xsAsString, String elementToGenerate, boolean enableDownloads,
                                    boolean noPvr, boolean noUpa){
    List<XmlObject> schemaXmlObjects = new ArrayList<>();
    try {
      schemaXmlObjects.add(XmlObject.Factory.parse(xsAsString));
    } catch (XmlException e) {
      logger.error("Error Occured while Parsing Schema",e);
    }
    XmlObject[] xmlObjects = schemaXmlObjects.toArray(new XmlObject[1]);
    SchemaInstanceGenerator.Xsd2InstOptions options = new SchemaInstanceGenerator.Xsd2InstOptions();
    options.setNetworkDownloads(enableDownloads);
    options.setNopvr(noPvr);
    options.setNoupa(noUpa);
    return xsd2inst(xmlObjects, elementToGenerate, options);
  }

  private String xsd2inst(XmlObject[] schemas, String rootName, SchemaInstanceGenerator.Xsd2InstOptions options){
    SchemaTypeSystem schemaTypeSystem = null;
    if (schemas.length > 0) {
      XmlOptions compileOptions = new XmlOptions();
      if (options.isNetworkDownloads())
        compileOptions.setCompileDownloadUrls();
      if (options.isNopvr())
        compileOptions.setCompileNoPvrRule();
      if (options.isNoupa())
        compileOptions.setCompileNoUpaRule();
      try {
        schemaTypeSystem = XmlBeans.compileXsd(schemas, XmlBeans.getBuiltinTypeSystem(), compileOptions);
      } catch (XmlException e) {
        logger.error("Error occurred while compiling XSD",e);
      }
    }
    if (schemaTypeSystem == null) {
      throw new RuntimeException("No Schemas to process.");
    }

    SchemaType[] globalElements = schemaTypeSystem.documentTypes();
    SchemaType elem = null;
    for (SchemaType globalElement : globalElements) {
      if (rootName.equals(globalElement.getDocumentElementName().getLocalPart())) {
        elem = globalElement;
        break;
      }
    }
    if (elem == null) {
      throw new RuntimeException("Could not find a global element with name \"" + rootName + "\"");
    }
    // Now generate it and return the result
    return SampleXmlUtil.createSampleForType(elem);
  }
}