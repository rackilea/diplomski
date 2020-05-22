package com.user.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
@Path("/UserLogin")
public class UserLogin {
@GET
@Produces(MediaType.TEXT_PLAIN)
public String respondAsReady() {
   return "Web service is ready!";
}
private String userName;
private String password;
private boolean rememberMe;
public UserLogin(){
}
@GET
@Path("/validUser")
@Produces(MediaType.TEXT_PLAIN)
public String validUserLogin() throws JSONException {
if ((this.userName == null) || (this.password == null)) {
        return "<p>Hello</p>";
    } 
return "<p>Hi</p>";
   }
}