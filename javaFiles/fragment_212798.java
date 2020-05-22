package com.ejb;
@Local
public interface MyEjbLocal{
       public String sendMessage();
}

package com.ejb;
@Remote
public interface MyEjbRemote{
       public String sendMessage();
}

@Stateless(mappedName = "ejb/MessageSender")
public class MyEjbImpl implements MyEjbLocal, MyEjbRemote{
 public String sendMessage(){
   return "Hello";   
 }
}