public class JsonReader{
     public JsonObject object; //field in your class (still not instantiated)
     public JsonReader(){
         object = readMyJson(); //declare a readMyJson method to retrieve your object
         ...
     }
     //other methods
     public someFunction(){
         //here you have access to your object.
     }
}