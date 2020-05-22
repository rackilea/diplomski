@RequestMapping(value = "/test", method = RequestMethod.POST)
public String test(
        @RequestBody String body,
        @RequestParam("param1") String parma1,
        Map<Object, Object> model: Map[AnyRef, AnyRef])
{
    model.put("test", test)
    model.put("body", body)

    return "Layout"
}