@RequestMapping("/getStates")
        public ModelAndView getStates(@RequestParam("country")String countryCode){
       ModelAndView mv = new ModelAndView("yourCurrentView");     
List<States> states = stateService.findAllStatesOfCountry(countryCode);
    mv.add("states",states);
    //to make sure countries drop down also has data
    mv.add("countries",countries);
    }