String[] allowedActions;
switch (taskName){
case "Payment" :
    allowedActions = new String[] { "full-payment", "bill-payment"};
    break;
case "Transfer" :
    allowedActions = new String[] { "transfer-to-other", "tarnsfer-to-own"};
    break;
}