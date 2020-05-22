@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
public String addCustomer(@ModelAttribute("Residents") Residents residents){

     //Just some printouts for confirmation
     System.out.println(residents.getName());
     System.out.println(residents.getSurname());

     //Persist data

}