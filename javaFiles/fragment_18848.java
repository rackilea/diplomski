public class Foo
{
   public String bar;
   public String baz;

   public void setNamedProperty(String name, String value) {
       switch (name) {
       case "bar": 
           bar = value;
           break;
       case "baz": 
           baz = value;
           break;
       default:
           throw new IllegalArgumentException("Unknown property name");
       }
   }
}