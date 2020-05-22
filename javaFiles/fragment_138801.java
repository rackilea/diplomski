List<String> findCompanies(Map<String,Set<String>> companyToProducts, String product) {
    List<String> companies = new ArrayList<String>();
    for (Map.Entry<String,Set<String>> entry : companyToProducts) {
        Set<String> products = entry.getValue();
        if (products.contains(product)) {
            companies.add(entry.getKey());
        }
    }
    return companies;
}