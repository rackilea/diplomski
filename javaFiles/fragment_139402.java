@RequestMapping(value = "/add", method = RequestMethod.POST)
public String added(@RequestParam(value="id", required=false) String id, @RequestParam("name") String name, Model model) {
    City city;
    String operation;
    if(id== null){
        //create operation
        city = new City();
        operation = "CREATE";

    }else{
        //update operation
        city = service.findCity(id);
        operation = "UPDATE";
    }
    city.setCity(name);        
    service.saveCity(city); //save or update
    model.addAttribute("city", city);
    model.addAttribute("operation", operation); //add operation param
    return "add";
}