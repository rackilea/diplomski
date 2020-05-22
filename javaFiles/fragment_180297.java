@Entity
 public class User {
   @PrimaryKey
   private final int uid;
   private String name;
   @ColumnInfo(name = "last_name")
   private String lastName;

   public User(int uid) {
       this.uid = uid;
   }
   public String getLastName() {
       return lastName;
   }
   public void setLastName(String lastName) {
       this.lastName = lastName;
   }

   @Ignore
   User(String firstName, String lastName) {
      this.lastName = lastname;
      this.name = firstName;
   }
 }