@RequestMapping(value="/getTemperature/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String getTemparature(@PathVariable("id") Integer id){
        String weather = someDaoObect.getTemperature(id);
                return weather;
    }