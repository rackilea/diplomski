public List<String> getReport(List<BDDObject> records) {
List<String> reports = new ArrayList<String>(record.size());
    for (BDDObject record:records) {
    String newMedcondRefChild = String.valueOf(record.getValue( IDDConstants.IDD_THERAPY_AREA_REF_VALUE))
            .toLowerCase()
            .trim() + String.valueOf(record.getValue(IDDConstants.IDD_THERAPY_AREA_REF_TYPE_NAME))) 
            .toLowerCase().trim());
    reports.add(newMedcondRefChild);
    }
    return reports;
}