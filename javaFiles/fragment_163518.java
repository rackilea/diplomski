import java.io.*;
public class aw
{
    public static void main(String args []) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        boolean vince = false;
        System.out.print("Enter Element :");
        int a = Integer.parseInt(in.readLine());
        int [] jes = new int[a];

        for(int i=0; i<jes.length; i++) {
            System.out.print("Numbers :");
             jes[i] = Integer.parseInt(in.readLine());

        }

        System.out.print("Enter search:");
        int x = Integer.parseInt(in.readLine());
        for(int i=0; i < jes.length; i++) {
            if(jes[i] == x) {
                vince = true;
                break; //found the value, no need to keep iterating
            }
        }

        if(vince == true) {
            System.out.print("Array "+jes[i]+ "Found at Index"+i);
        }
    }
}