@RequestMapping(value = "/role-service-search", method = RequestMethod.GET )
public void searchRoleService(
                   @ModelAttribute("request") final PageableRoleServiceSearchRequest request,
                   @RequestParam(name = "id", required = false) final String role,
                   final BindingResult result) {
    if (request.getInput() == null) {
        RoleServiceSearchRequest newReq= new RoleServiceSearchRequest();
        if(role!=null)
        {
            newReq.setChannelRole(role);
        }

        request.setInput(newReq);
    }
}