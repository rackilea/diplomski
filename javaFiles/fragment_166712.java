Query query=  session.createQuery("from Account where name=?");

Account user=(Account)query.setString(0,user.getName()).uniqueResult();
if(user!=null){
   //Do whatever you want to do
}else{
  //Insert user
}