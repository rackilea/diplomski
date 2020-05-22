package decimalBinary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecBin {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int conargs1,conargs2;
        // conargs1 is input
        // conargs2 is mode, if = 1 then dec2bin, if = 2 then bin2dec
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number: ");
        conargs1=Integer.parseInt(br.readLine());
        System.out.println("Enter mode: ");
        conargs2 = Integer.parseInt(br.readLine());
        System.out.println(conargs2==1 ? "Dec2Bin" : (conargs2==2 ? "Bin2Dec" : "none"));
        if (args.length == 2){ // TO BINARY
            if(conargs2==1){
                System.out.println(DecBin.dec2bin(String.valueOf(conargs1)));
            }else if (conargs2==2){ // TO DECIMAL
                System.out.println(DecBin.bin2dec(String.valueOf(conargs1)));
            }
            System.exit(0);
        }
    }

    public static String dec2bin(String arg){
        String out = null;
        String tmp;
        long i, x;
        int maxpower = 30;
        x = Integer.parseInt(arg);

        if (x == 0){
            return "0";
        }else if (x > 0){ // positive decimals
            if (x > Math.pow(2, maxpower)) {
                return "should be no larger than " + String.valueOf(2 ^ maxpower);
            }
            out = "";

            int binary[] = new int[30];
            int index = 0;
            while(x > 0){
                binary[index++] = (int) (x % 2);
                x = x/2;
            }

            for(i = index-1;i >= 0;i--){
                out = out+binary[(int) i];
            }
        }else{ // negative decimals
            // x = -x;
            x = Math.abs(x); // convert positive of decimal to binary 
            if (x > Math.pow(2, maxpower)) {
                return "should be no larger than " + String.valueOf(2 ^ maxpower);
            }
            long xBinaryPositive;
            xBinaryPositive = Long.parseLong(DecBin.dec2bin(String.valueOf(x)));
            String xBinaryInverted;
            out = "";


            xBinaryInverted = String.valueOf(xBinaryPositive).replace('0', '2').replace('1', '0').replace('2', '1');
            long xBinaryInvertedIntVal;
            xBinaryInvertedIntVal = DecBin.bin2dec(xBinaryInverted);
            out = DecBin.dec2bin(String.valueOf(xBinaryInvertedIntVal+1));
        }
        return out;
    }

    public static long bin2dec(String binaryInput){
        long binary = Long.parseLong(binaryInput);
        long decimal = 0;
        long power = 0;
        while(true){
            if(binary == 0){
                break; 
            } else {
                long tmp = binary % 10;
                decimal += tmp * Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        } 
        return decimal; 
    }
}