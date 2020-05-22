public class TestMain
{
  public static void main(String []args)
   {
     UserID obj=new UserID("firstName","secondName");
     //Using obj reference variable, you can request to the object for any message.
     System.out.println(obj.getId() + " " + obj.getPassword());
   }
}