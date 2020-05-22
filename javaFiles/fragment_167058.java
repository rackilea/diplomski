import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Coddersclub {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("test.txt"));
        ArrayList<String> list = new ArrayList<String>();
        String str = "";
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            String[] specs = str.split(",");
            for (String item : specs) {
                list.add(item.substring(item.indexOf(":") + 1).trim());
            }
        }
        System.out.println(list);
    }
}