// when get account summary is clicked it will call this method  
@RequestMapping(value="/account/{accountid}/summary", method=RequestMethod.GET)  
public @ResponseBody String getAccountSummary(@PathVariable(value="accountid") String accountid){  

    return somefunct.getAccountSummary(accountid);  

}