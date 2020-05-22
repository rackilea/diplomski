class myPOJO implements Serializable{
private static final long serialVersionUID = 8683452581122892189L;
   transient private String attribute1;
   transient private String attribute2;

   public myPOJO(String value1, String value2){

    attribute1 = value1;
    attribute2 = value2;
   }

   private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
//always do defaultWriteObject. Helps in few Edge cases
    s.defaultWriteObject();
    s.writeObject(attribute1);
    s.writeObject(attribute2);
   }
    private void  readObject(java.io.ObjectInputStream s) throws java.io.IOException{
    //always do defaultReadObject. Helps in few Edge cases.
      s.defaultReadObject();
     attribute1 = (String) s.readObject();
     attribute2 = (String) s.readObject();
   }
   public String getAttribute1(){
      return attribute1;
   }

   public void setAttribute1(String value){
      attribute1 = value;
   }

   public String getAttribute2(){
      return attribute2;
   }

   public void setAttribute2(String value){
     attribute2 = value;
   }