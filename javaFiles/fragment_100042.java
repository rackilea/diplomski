String previousId = null;  
while(result_set.next()){
   String tagId = result_set.getString("tagId");
   String accountId = result_set.getString("accoundId");
   if (previousId == null) {
     // this would be the first iteration
   } else if (previousId.equals(accountId) {
    // go here
   } else {
     // go here
   }
   previousId = accountId;
}