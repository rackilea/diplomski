@RequestMapping(value="/person/{personId}", method=RequestMethod.GET)
@ResponseBody
public String getPerson(@PathVariable("personId") String personId) {

    logger.info(RestController.class.getName() + ".getPerson() method called."); 

    Person person = personService.get(Integer.parseInt(personId));

    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(person);

}