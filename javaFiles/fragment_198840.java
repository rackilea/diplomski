public class ConnectionStateService { 

// static variable instance of type Singleton 
private static ConnectionStateService single_instance = null; 

// private constructor restricted to this class itself 
private ConnectionStateService() { 
 // some stuffs for initialize here
}  

// static method to create instance of Singleton class 
public static ConnectionStateService getInstance()  { 
if (instance == null) 
     instance = new ConnectionStateService(); 
     return instance; 
}