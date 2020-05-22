package problems;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileRd {

    public static void main(String args[]) {
        try {
            String lokasi = "D:/settings.txt";
            String username = txtUser.getText();
            String password = txtPass.getText();

            FileReader fr = new FileReader(lokasi);
            BufferedReader br = new BufferedReader(fr);
            String line, user, pass;
            boolean isLoginSuccess = false;
            while ((line = br.readLine()) != null) {
                user = line.split(" ")[1].toLowerCase();
                pass = line.split(" ")[2].toLowerCase();
                if (user.equals(username) && pass.equals(password)) {
                    isLoginSuccess = true;
                    this.dispose();
                    MainMenu mm = new MainMenu();
                    mm.setLocationRelativeTo(null);
                    mm.setVisible(true);
                    break;
                } 
            }
            if (!isLoginSuccess) {
                JOptionPane.showMessageDialog(null, "USERNAME/PASSWORD WRONG", "WARNING!!", JOptionPane.WARNING_MESSAGE);
            }
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}