@RequestMapping(value = "/countryList.html")
public Collection<Country> getCountries(ModelMap model) {     
        model.addAttribute("countries", countryObject);
   return viewName;

     }