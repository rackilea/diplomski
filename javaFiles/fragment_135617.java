JSOnObject resp = `{"id":"12","datetime":"08:39:02","status":good,"first_name":"ABC","last_name":"xyz"}`;
String status = resp.getAsString("status");
if(status.equalsIgnoreCase("good")){
  //set Flag
}

if(status.equalsIgnoreCase("bad")){
  //call function
}