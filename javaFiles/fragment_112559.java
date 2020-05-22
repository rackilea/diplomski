package stackoverflow.q_25034927;

import java.util.HashMap;
import java.util.Map;

public class PassVariable {

    public void onCreate() {
        final Map<String, String> contact = new HashMap<String, String>();
        //populate contact object as per your logic.
        getContacts(contact);
    }

    private void getContacts(Map<String, String> contact) {
        //Use contact object which is passed as argument.
    }
}