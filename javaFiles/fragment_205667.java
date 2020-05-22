@ActionMapping(params = "doAction=searchDeviceResults")
public void searchResults(@ModelAttribute(value = "searchForm") SearchForm searchForm,
                          BindingResult bindingResult, 
                          ActionRequest request, 
                          ActionResponse response, 
                          SessionStatus sessionStatus) {

    searchFormValidator.validate(searchForm, bindingResult);

    if (!bindingResult.hasErrors()) {
        response.setRenderParameter("doAction", "showDeviceResults");
        sessionStatus.setComplete();    
        List<AccountDetail> accList = accountService.getAccountDetail(adp);
        request.setAttribute("accountList", accList); // here we go
    }

}