import java.util.ArrayList;
import java.util.List;

public class StaffChecker {


public static void main(String[] args) throws Exception {

    // Creating objects is expensive, you should do this as little as possible
    StaffCheckBO staffCheckBO = new StaffCheckBO();

    // variables should be Camel Cased and describe what they hold
    // Never start with ArrayList start with List you should specific the interface on the left side.
    List<String> staffList = new ArrayList<String>();
    staffList.add("tom");
    staffList.add("Laura");
    staffList.add("Patricia");

    // use a foreach loop not a (int x = 0 ... ) This is the preffered method.
    for (String staffMember : staffList) {
        // You now dont need to use .get() you can access the current variable using staffMember
        System.out.println(staffMember);

        // Do the work
        staffCheckBO.checkUser(staffMember);
    }
  }
}