import java.io.*;

public class ReadInt{
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean check;
        int i = 0;
        System.out.print("Integer: ");
        do{
            check = true;
            try{
                i = Integer.parseInt(in.readLine());
            } catch (NumberFormatException e){
                System.err.println("Input error - Invalid value for an int.");
                System.out.print("Reinsert: ");
                check = false;
            }
        } while (!check);
        System.out.print(i + " + 7 = " + (i+7));
    }
}