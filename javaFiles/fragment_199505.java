Map<Key, List<String>> employeesByKey = new HashMap<>();
for (MyRecord record : myRecordList) {
    for (EmployeeCategory ec : record.getEmployeeCategories()) {
        Key key = new Key(record.getLocation(), ec.getCategory());
        employeesByKey.computeIfAbsent(key, k -> new ArrayList<String>()).add(ec.getEmployee());
    }
}

List<MyCollapsedRecord> result = 
    employeesByKey.stream()
                  .map(entry -> new MyCollapsedRecord(entry.getKey().getLocation(), entry.getKey().getCategory(), entry.getValue()));
                  .collect(Collectors.toList());