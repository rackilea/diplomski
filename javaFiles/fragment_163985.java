String message = "";
if (issuance !=null && prem.compareTo(totalzero) == 1 && issuance.compareTo(totalzero) == -1) {
  message = "the value of issuance has a different sign to the sign of premium";
}

if (claimhandling != null && prem.compareTo(totalzero) == 1 && claimhandling.compareTo(totalzero) == -1) { 
  if (message.length() > 0) {
    message += "<br>";
  }
  message += "the value of claimhandling has a different sign to the sign of premium";
}

if (message.length() > 0) {
  ConfirmationDialog.showConfirmationDialog(this, "<html>" + message+ "</html>");
}