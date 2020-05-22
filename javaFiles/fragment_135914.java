import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

...

public class ContactsProcessor {
    public static void main(String[] args) {
        List<String> contactsNew = Files.readAllLines(Paths.get("contactsNew.tsv"));
        List<String> contactsOld = Files.readAllLines(Paths.get("contactsOld.tsv"));
        List<String> contactsGmail = new ArrayList<String>();
        Map<String, String> gmailMap = new HashMap<String, String>();

        // process old contacts first -- add to a Map
        for (String info : contactsOld) {
            String[] parts = info.split("\\t");
            if (info.endsWith("@gmail.com")) {
                gmailMap.put(parts[0], info);
            }
        }
        // process new contacts second -- add to a Map, overwriting old contacts with same name
        for (String info : contactsNew) {
            String[] parts = info.split("\\t");
            if (info.endsWith("@gmail.com")) {
                gmailMap.put(parts[0], info);
            }
        }
        contactsGmail.addAll(gmailMap.values());
        Collections.sort(contactsGmail);

        Files.write(Paths.get("contactsGmail.tsv"), contactsGmail);
    }
}