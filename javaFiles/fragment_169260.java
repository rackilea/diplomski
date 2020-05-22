import java.io.*;

class charequals {

    public String name1, name2;
    int l1, l2, m;

    void getInputs() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));
            System.out
                    .println("Enter First Name(Enter \"1\" for \"AMITABH BACHCHAN\")\n");

            name1 = br.readLine();
            if (name1.equals("1"))
                name1 = "AMITABH BACHCHAN";
            System.out
                    .println("Enter Second Name(Enter \"1\" for \"RAJNIKANTH\")\n");

            name2 = br.readLine();
            if (name2.equals("1"))
                name2 = "RAJNIKANTH";
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void findEquals() {
        getInputs();
        l1 = name1.length();
        l2 = name2.length();
        for (int i = 0; i < l1; i++) {
           for (int j = 0; j < l2; j++) {
                if ( name1.charAt(i) == name2.charAt(j) ) {
                    System.out.print(name2.charAt(j) + " " );
                    char[] chars = name2.toCharArray();
                    chars[j] = '&';
                    name2 = new String(chars);
                    break;
                }
           }
        }
    }

    public static void main(String[] args) {
        charequals a = new charequals();
        a.findEquals();
    }
}