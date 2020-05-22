public dbManager(String dburl,String username,String password){
   this.dburl=dburl;
   this.username=username;
   if (password != null && password.length() != 0) {
       this.password=password;
   }
}