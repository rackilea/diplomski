grant Principal SysAdminPrincipal "sysadmin"
{

   permission java.net.SocketPermission "127.0.0.1:8080","connect,resolve";
   permission java.net.URLPermission "http://localhost:8080/HelloWorldREST/helloworld","GET";
}; 

grant Principal UserPrincipal "user"
{

};