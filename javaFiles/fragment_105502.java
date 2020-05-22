import java.io.*;

public class Test
{
    public static void main(String[] args) throws Exception {
        Test.readIN();
    }

    public static void readIN() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        String line = null;    
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            Test.checkStatus(values);
        }
        br.close(); 
    }


    public static void checkStatus(String[] values) {
        // call variable 'values' here
        System.out.println(values);
    }
}