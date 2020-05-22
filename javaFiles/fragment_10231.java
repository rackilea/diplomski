List<Company> sortedList = new ArrayList<>();
Map<String, Company> map = new HashMap<>();
for(Company company : companiesSource){
    map.put(company.getCode(), company);
}
for(String desired : desiredCompanies){       
    sortedList.add(map.get(desired));
}