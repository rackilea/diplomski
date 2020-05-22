@RequestMapping(value = "/generate", method = RequestMethod.GET) 
@ResponseBody public List<YourFacturerClass> generate() {

    return facturationSvc.facturer();

}