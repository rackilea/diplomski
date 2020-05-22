public List<String> getReport(List<BDDObject> records) {
List<String> reports = new ArrayList<String>(record.size());
    for (BDDObject record:records) {
        reports.add(record.toString());
    }
    return reports;
}