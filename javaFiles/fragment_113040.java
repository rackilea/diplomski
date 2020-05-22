public class Parent{
   private String a;
   private String b;
   @XmlJavaTypeAdapter(Adapter.class)
   private String c;

   @XmlTransient
    public String getC() {
        return c;
    }
   //getters and setters for b,a and setter for C
}