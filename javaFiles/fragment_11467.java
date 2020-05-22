public class MyEntity {
   @Column(length=100000)
   String prop;

   public void setProp(String c) {
       prop=c;
   }

   public String getProp() {
       return prop;
   }
}