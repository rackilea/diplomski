class User(){
private String pass;
private String uname;

    public User(String p,String u){
      pass=p;
      uname=u;
    }
    public boolean authenticate(){
      if("secret".equals(this.pass) && "Grrrr".equals(this.uname){
         return true;
      }else{
         return false;
      }
    }
    public static void main(String[]args){
     User u = new User("wrong secret","grrr");
     System.out.println(u.authenticate());
    }
  }