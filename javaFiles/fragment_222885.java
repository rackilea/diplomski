public class User
{
   // personal properties
   private String name;
   private String surname;
   private Calendar dateOfBirth;

   // account properties;
   private String login;
   private String password; // note that string may be more convenient than char[]

   // role properties
   public ArrayList<Role> roles;
   ...

   public bool hasRole(Role role) // or isInRole(Role role)
   { // implementation here. }
}