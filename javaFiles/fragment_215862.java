public class SharedValues{

     private static SharedValues sharedValues = new SharedValues();
     //will always return the same instance of this class
     public static SharedValues getInstance() {
        return sharedValues;
     }

     private boolean capicua;

     public void setCapicua(boolean capicua)
     {
         this.capicua = capicua;
     }

     public boolean getCapicua()
     {
        return this.capicua;
     }
}