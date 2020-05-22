public String overview(HttpServletRequest request, Model model) {
Attrs attrs = getAttrs(request);
UserLocale.initUser(getUser(request));
User user = UserLocale.getUser();
List<FactoryMaster> factoryList = getFactoryList(attrs);
List<CountryMaster> countryList = getCountryList(attrs);
Command command = initCommand(attrs);
model.addAttribute(command);
if(user.hasRole(User.NORMAL)&& user.getCountryCode() != null){

    if(countries == null){
         countries=  getDaoBuilder().getDaoCountry().countryMap();               
     }

    String isoCode = countries.get(user
            .getCountryCode());
    List<CountryMaster> buffer = new ArrayList<CountryMaster>();
    for(CountryMaster i : countryList){
        if(isoCode.equalsIgnoreCase(i.getIsoCode())){
            buffer.add(i);                  
        }
    }
    System.out.println("List size: "+buffer.size());
    command.setCountries(buffer); 

    // FIXED SELECTION OF ELEMENT
    command.setFactoryValues(new String[]{isoCode});
    // FIXED SELECTION OF ELEMENT   

}
else{
    command.getCountries().addAll(getCountryList(attrs));
}

    command.getModels().addAll(getModelList(attrs));
    command.setBrands(getBrandList(attrs));
    return "/reporting/overview";
}