import java.util.*;
import java.io.*;

public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        String str, str1, str2;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));
            while (true) {

                System.out
                        .print("Do you want to add a contact? press any key to continue or n to exit :");
                String str5 = br.readLine();

                if ("n".equalsIgnoreCase(str5)) {
                    System.exit(1);
                }

                System.out.print("Enter your First Name :");
                str = br.readLine();

                System.out.print("Enter your Last Name :");
                str1 = br.readLine();

                System.out.print("Enter your Phone Number :");
                str2 = br.readLine();

                StringBuilder sb = new StringBuilder();
                sb.append(str + str1 + str2);

                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    if (s.equals(sb.toString())) {
                        System.out.println("Duplicate");
                        list.remove(i);
                    }
                }
                list.add(sb.toString());

                System.out
                        .print("Do you want to add contracts? press y to continue :");
                String str3 = br.readLine();
                System.out.println("You just entered:" + str3);

                if ("y".equalsIgnoreCase(str3)) {
                    System.out
                            .print("Which contract do you wish to be removed?");
                    String str4 = br.readLine();

                    int index = Integer.parseInt(str4);
                    if (index < list.size() && index > 0) {
                        list.remove(index);
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}