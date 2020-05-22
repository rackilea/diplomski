@RequestMapping(value = "/json-new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public String handleJsonProperty(@JsonObjectProperty(name = "userId") String userId) {
    String result = userId;
    System.out.println(result);
    return result;
}