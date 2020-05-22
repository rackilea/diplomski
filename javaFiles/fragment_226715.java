typeDesc.setXmlType(new QName("sbatimentto", "RechercherBatimentRetour")); // 1
org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
elemField.setFieldName("batiments");
elemField.setXmlName(new QName("", "batiments")); // 2
elemField.setXmlType(new QName("sbatimentto", "ResumeBatimentTo"));
elemField.setNillable(true);
typeDesc.addFieldDesc(elemField);