@RequestMapping(value="/account/{accountid}/details", method = RequestMethod.GET)
public @ResponseBody String getAccountDetails(@PathVariable(value="accountid") String accountid){  

 return somefunct.getAccountDetails(accountid);  

}