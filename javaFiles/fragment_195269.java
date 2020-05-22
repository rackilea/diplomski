List<Country> countryList = new ArrayList<Country>();

public String executeAction() throws Exception {
  try {
     countryList = this.countrySecurityProcessor.findByAll(0, null, null, null, null, false, false, null, null, null, null, 0);
     System.out.println("countryList = "+countryList);
     return ActionSupport.SUCCESS;

  } catch (Exception ex) {
     return ActionSupport.ERROR;
  }

}

public List<Country> getCountryList() {
  return countryList;
}