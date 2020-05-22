public String getReport(List<BDDObject> records) {
StringBuilder sb = new StringBuilder();
    for (BDDObject record:records) {
        sb.append(String.valueOf(record.getValue( IDDConstants.IDD_THERAPY_AREA_REF_VALUE))
            .toLowerCase()
            .trim());
        sb.append(String.valueOf(record.getValue(IDDConstants.IDD_THERAPY_AREA_REF_TYPE_NAME)) 
            .toLowerCase().trim()));

    }
    return sb.toString();
}