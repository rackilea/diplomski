import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        FileReader in = null;
        BufferedReader br = null;

        BufferedWriter uOut = null;
        BufferedWriter pOut = null;

        try {

            in = new FileReader("data.txt");
            br = new BufferedReader(in);

            uOut = new BufferedWriter(new FileWriter("username.txt"));

            pOut = new BufferedWriter(new FileWriter("password.txt"));

            String line = br.readLine();
            while (line != null) {

                boolean migrated = true;

                if (line.contains(":")) {

                    String[] split = line.split(":");
                    String user = split[0];
                    String pass = split[1];
                    if (user.contains("@") && user.contains(".com")) {
                        migrated = false;
                    }

                    if (migrated) {
                        uOut.write(user, 0, user.length());
                        uOut.newLine();

                        pOut.write(pass, 0, pass.length());
                        pOut.newLine();
                    } else {
                        pOut.write(user, 0, user.length());
                        pOut.newLine();
                        pOut.write(pass, 0, pass.length());
                        pOut.newLine();
                    }

                    line = br.readLine();
                    continue;
                }

                if (!(line.contains("@") && line.contains(".com"))) {
                    pOut.write(line, 0, line.length());
                    pOut.newLine();

                    line = br.readLine();
                    continue;
                } else {
                    uOut.write(line, 0, line.length());
                    uOut.newLine();

                    line = br.readLine();
                    continue;
                }

            }

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (br != null) try {
                br.close();
            } catch (Exception ex) {
            }

            if (uOut != null) try {
                uOut.close();
            } catch (Exception ex) {
            }

            if (pOut != null) try {
                pOut.close();
            } catch (Exception ex) {
            }

        }

    }
}