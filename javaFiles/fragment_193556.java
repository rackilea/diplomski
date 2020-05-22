// Obtain the XML Schema implementation
XSImplementation impl = (XSImplementation)
  (new DOMXSImplementationSourceImpl()).getDOMImplementation(XMLConstants.XSD_LOADER_NAME);

// Get schema loader
XSLoader schemaLoader = impl.createXSLoader (null);

// Optional. Specify error handler
DOMErrorHandler errorHandler = ....;
DOMConfiguration config = schemaLoader.getConfig();
config.setParameter("error-handler", errorHandler);

// Optional. Specify XML catalog resolver.
// This may be needed to redirect internal DTD/schema file references
XMLCatalogResolver catalogResolver = ...;
config.setParameter("resource-resolver", catalogResolver);

String xsdURI = ...; // the location of schema file

// read schema
XSModel xsModel = schemaLoader.loadURI(xsdURI);

// PROCESS SCHEMA (here, you can do anything you want)

XSNamedMap xsMap;

// process top-level element declarations
xsMap = xsModel.getComponents(XSConstants.ELEMENT_DECLARATION);
for (int i = 0; i < xsMap.getLength(); i ++)
{
  XSElementDeclaration xsElementDecl = (XSElementDeclaration) xsMap.item(i);
  ...
}

// process top-level type definitions
xsMap = xsModel.getComponents(XSConstants.TYPE_DEFINITION);
for (int i = 0; i < xsMap.getLength(); i ++)
{
  XSTypeDefinition xsTDef = (XSTypeDefinition) xsMap.item(i);
  ...
}

// process model group definitions
xsMap = xsModel.getComponents(XSConstants.MODEL_GROUP_DEFINITION);
for (int i = 0; i < xsMap.getLength(); i ++)
{
  XSModelGroupDefinition xsGroupDef = (XSModelGroupDefinition) xsMap.item(i);
  ...
}

...