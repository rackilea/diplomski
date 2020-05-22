@PostMapping(value = "/v1/notification")
@ResponseStatus(HttpStatus.OK)
public String handleNotifications(@RequestParam("notification") String itemid) throws MyException {
    if(someCondition) {
       throw new MyException("some message");
    }
    // parse here the values
    return "result successful result";
}