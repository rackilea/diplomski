if(account instanceof PremiumAccount){
    //if we're sure that account is actually a PremiumAccount,
    //cast it to a PremiumAccount here to let the compiler know
    //that doSomethingPremiumLike() can be called 
   ((PremiumAccount)account).doSomethingPremiumLike();
}