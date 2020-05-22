package stackoverflow.q_25034927;

import java.util.HashMap;
import java.util.Map;

public class PassVariable {
    private static Map<String, String> contact = new HashMap<String, String>();

    public void onCreate() {
        //populate contact object as per your logic
        getContacts();
    }

    private void getContacts() {
        //Use contact object directly which was pre-populby onCreate method.
    }
}