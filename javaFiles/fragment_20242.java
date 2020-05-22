@RequestMapping(value = "/sendmail/sendInvitations",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody returnType methodName(@RequestParam Map<String, String> name) {
    ...
}