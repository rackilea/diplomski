public class Project implements Serializable {
   public int id;
   public String name;
   public String additional_information;
   public EmergencyContact emergency_contact;
   public EmergencyOwner emergency_owner;

   public Project(int id, String name, String additional_information, EmergencyContact emergency_contact, EmergencyOwner emergency_owner){
     // assign the fields here as well
   }
}