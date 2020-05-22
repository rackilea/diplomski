import java.io.Serializable;

public class Person implements Serializable
{
     private String username;
     private int    id;

     public String UserName() { return username; }
     public void setUserName(String str) { username = str;} 

     public int ID() { return id; }
     public void setID(int ID) { id = ID; }    
}