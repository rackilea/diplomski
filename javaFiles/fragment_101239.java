@RequestMapping("/locationUpdate.do")
    public String locationUpdate(Map<String, Object> map,@ModelAttribute("location") Location location, BindingResult result) {
        map.put("location", locationService.getLocationByCode(locationcode));
        map.put("locGrp", listLocationGroup());

        return "location/locationAdd";
    }