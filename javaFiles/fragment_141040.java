if (userInfo.contains(username)){
  if(userInfo.get(username).getLast().equals(password){
   return true;
  } else {
   //Bad password
   return false;
  }
}
//Unknown user
return false;