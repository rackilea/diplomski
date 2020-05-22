try
{
transport.connect(host, port, user, pwd);
}
 catch(AuthenticationFailedException e) {
   System.out.println("AuthenticationFailedException - for authentication failures");
   }