public class A {
   // ...
   private long bCount;

   // ...

   @Formula( "(select count(*) from B where B.A_id = id" )
   public long getBCount() {
      return this.bCount;
   } 

   public void setBCount( long bCount ) {
      this.bCount = bCount;
   }
}