import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public String UTF8 = "utf8";
public int BUFFER_SIZE = 8192;

private void store (String filename, String data)
{
    try {
        BufferedWriter fOut = new BufferedWriter(new OutputStreamWriter(openFileOutput(filename, MODE_PRIVATE), UTF8), BUFFER_SIZE);
        fOut.write(data);
        fOut.close();
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
}

private String read(String namefile, String datxt)
{
    try {
        BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput(namefile), UTF8), BUFFER_SIZE);
        int c;
        String temp = "";
        while ((c = fin.read()) != -1) {
            temp = temp + Character.toString((char) c);
        }
        datxt = temp;
        fin.close();
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
    return datxt;
}