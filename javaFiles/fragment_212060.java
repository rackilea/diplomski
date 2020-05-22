@ResponseBody
@RequestMapping(value="/index.do", method=RequestMethod.GET)
public String populatePivotAndSheet(@RequestParam("displayType") String type) {

    String returnedJSON = "";

    try {
         returnedJSON = getJSON.getJSON(type);
    } catch (Exception ex) {
        System.out.println("Unable to retrieve JSON");
    }

    return returnedJSON;

}

@ResponseBody
@RequestMapping(value="/index.do", method=RequestMethod.POST)
public void deliverSheet(@RequestParam("jsonString") String writableJSON) {

    String returnedJSON = "";

    JsonWriter.writeJSON(writableJSON);

}