@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
    method = RequestMethod.GET
    value = "/foo/bar")
@ResponseBody
public Bar fooBar(){
    return myService.getBar();
}