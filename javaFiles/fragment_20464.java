// delete user record
GSRequest deleteAccountRequest = new GSRequest(apiKey, secretKey, "accounts.deleteAccount");
//deleteAccountRequest.setAPIDomain("eu1.gigya.com");  // enable this if you're using the EU data centre
deleteAccountRequest.setUseHTTPS(true);
deleteAccountRequest.setParam("UID", uid);
GSResponse deleteAccountResponse = deleteAccountRequest.send();
if(deleteAccountResponse.getErrorCode()==0)
{     
} 
else 
{  
    System.out.println("deleteAccountResponse failure: " + deleteAccountResponse.getLog());
}