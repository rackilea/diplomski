public abstract class XmlFactory 
{
     public static XmlReturn getInstance(String type)
     {
         // Using string as an example type. Doesn't need to be.
         if(type.equals("Admin")) {
              return new AdminXmlReturn();
         }
     }
}