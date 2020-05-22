package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ReadFile {
    public static void main(String[] args) {
        ReadFile o = new ReadFile();
        o.read("test.txt", 2, 0);
    }
    private void read(String text_file, int len, int index) {

        BufferedReader bufferedReader ;
        String[] stringBuffer = new String[len]; 
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/META-INF/".concat(text_file))));

            String line;
            int i = 0;
            while ( (line = bufferedReader.readLine()) != null) {
                stringBuffer[i] = line; 
                i++;
            }
            bufferedReader.close();

        } catch (FileNotFoundException fnde) {
            fnde.printStackTrace();
            JOptionPane.showMessageDialog(null, "files could not be found", "Help", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        splitString(stringBuffer, index);   
    }

    private void splitString(String[] stringBuffer, int index) {
        for(String line: stringBuffer) {
            System.out.println(line);
        }

    }
}