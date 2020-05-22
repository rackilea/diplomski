public class MyObjectExtendingRealmObject extends RealmObject {
   public MyObjectExtendingRealmObject() { // needed
   }

   public MyObjectExtendingRealmObject(String name) {
       this.name = name;
   }

   @PrimaryKey
   private String name;

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }
}