import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindStringInFileTest {

    public static void main(String[] args) {

        File f = new File("c:/test.txt");
        String res = find(f);

        if (res != null) {
            System.out.println("Found Meta Http-Equiv tag");
            System.out.println(res);//print META HTTP-EQUIV line
            //check the line for whatver dates etc here
        } else {
            System.out.println("Couldnt find Meta Http-Equiv tag");
        }

    }

    public static String find(File f) {
        String result = "";
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(f));
            while (in.hasNextLine()) {
                String tmp = in.nextLine();
                if (containsMetaHttpEquiv(tmp)) {
                    result = tmp;//assign line which has META HTTP-EQUIV tag
                    break;//so we dont check more
                } else {
                    result = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static boolean containsMetaHttpEquiv(String str) {
        if (str.contains("<META HTTP-EQUIV=\"Expires\" CONTENT=")) {
            return true;
        }
        return false;
    }
}