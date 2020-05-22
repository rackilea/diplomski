List<Company>  sortedList  = new ArrayList<Company>();
Map<String, Company> map = new HashMap<>();
for(Company company : companiesSource) {
   map.put(company.getCode(), company);
}
for(String desired : desiredCompanies) {
    if(map.get(desired) != null) {
        sortedList.add(map.get(desired));
    }
}