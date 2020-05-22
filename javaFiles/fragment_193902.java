import java.io.FileWriter;
import java.io.IOException;
import User;

 public class GenerateCsv
 {


    private static void generateCsvFile(ArrayList<User> users)
    {
        String output = "Email, Name\n";

        for (User user in users) {
            output += user.getEmail() + ", " + user.getName() + "\n";
        }

        return output;
    }
 }