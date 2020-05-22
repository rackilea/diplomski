// just to show JSP
@RequestMapping(value = "/front", method = RequestMethod.GET)
public String onemethod() throws IOException, ParseException {
    return "jsppage";
}

// REST
@ResponseBody
@RequestMapping(value = "/rest", method = RequestMethod.GET)
public String secondmethod() {
    return "something";
}