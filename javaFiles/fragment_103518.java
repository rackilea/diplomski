/**
 * Probably not really any need for this class but I'll assume further business logic may follow.
 */
public class StaffCheckBO {

// Again only create our DAO once...CREATING OBJECTS IS EXPENSIVE.
private StaffDAO staffDAO = new StaffDAO();

public void checkUser(String staffMember) throws Exception{

 boolean staffExists = staffDAO.checkStaffExists(staffMember);

     if(staffExists) {
         System.out.println(staffMember +" is not in database, doing new insert.");
         staffDAO.insertStaff(staffMember);
     } else {
         System.out.println(staffMember +" has been found in the database, updating user.");
         staffDAO.updateStaff(staffMember);
     }
   }
}