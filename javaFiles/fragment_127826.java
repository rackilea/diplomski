@PermitAll
@RequestMapping(value = "/external")
public String externalAuth(...) {
    if(someCondition) return "redirect:" + someExternalUrl; // [1] https://external-service.com 
    else return "redirect:/"
}