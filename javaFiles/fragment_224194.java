package blabla;

import java.io.Serializable;

public class UserData implements Serializable {

private String email;
private String password;

//1.Constructor
public UserData()
{
    email="";
    password="";

}

//2.Getters
public String getEmail(){
return email;
}

public String getPassword(){
return password;
}

//3.Setters - Caution: we use different variables here

public void setEmail(String eml)
{
this.email=eml;
}

public void setPassword(String pswd)
{ 
this.password=pswd;
}   }