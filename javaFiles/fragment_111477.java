e==null means that the call was successfully completed by the server. It does not imply that the user exists or not.
if(e==null){
if(scoreList == null || scoreList.isEmpty()){
 // The user does not exist.
}else{
// the user exists.
}
}else {
// You have an exception (like HTTPTimeout, etc). Handle it as per requirement.
}