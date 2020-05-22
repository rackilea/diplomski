OPCPackage pkg = OPCPackage.open(file);
POIXMLProperties props = new POIXMLProperties(pkg);
PackagePropertiesPart ppropsPart = props.getCoreProperties().getUnderlyingProperties();

Date created = ppropsPart.getCreatedProperty().getValue();
Date modified = ppropsPart.getModifiedProperty().getValue();

String lastModifiedBy = ppropsPart.getLastModifiedByProperty().getValue();