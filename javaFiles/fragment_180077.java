public class DomainClass1 {
   String str1, str2;

   public boolean isEmpty() {
      if (this.str1 != null && this.str2 != null) {
         return false;
      } else {
         return true;
      }
   }
}