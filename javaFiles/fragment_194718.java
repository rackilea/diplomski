@RequestMapping(value = "/jsonasclass", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody
ContactVO jsonAsClassGet(ContactVO  ct){
    ct.setFirstName("This-property-is-changed-in-the-controller");
    return ct;
}