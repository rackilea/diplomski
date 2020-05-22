import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Binary {

    public static void main(String[] args) {
        System.out.println("Started");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an integer : ");
        int num = Integer.parseInt(scan.nextLine());
        System.out.println("Enter base to convert to: ");
        int base = Integer.parseInt(scan.nextLine());

        scan.close();

        Integer[] bitArray = convertToBaseArray(num, base);

        System.out.println(Arrays.toString(bitArray));
    }

    private static Integer[] convertToBaseArray(int num, int base) {
        if(base == 0) {
            throw new RuntimeException("base can not be 0");
        } else if(num < 0 && base > 0) {
            throw new RuntimeException("positive base can not produce negative number");
        }
        List<Integer> bitList = new ArrayList<Integer>();

        int absoluteBase = Math.abs(base);
        if(base == 1) {
            //this is not unique, creating shortest bit array
            for(int i = 0; i < Math.abs(num); i++) {
                bitList.add(1);
            }
        } else if(base == -1) {
            //this is not unique, creating shortest bit array
            int evenBit = num > 0 ? 0 : 1;
            int oddBit = 1-evenBit;

            for(int i = 0; i < 2*Math.abs(num); i+= 2) {
                bitList.add(oddBit);
                bitList.add(evenBit);
            }
            if(oddBit == 1) {
                bitList.remove(bitList.size() -1);
            }
        } else {
            while(num != 0) {
                int remainder = num % base;
                if(remainder < 0) {
                    remainder += absoluteBase;
                    num -= absoluteBase;
                }
                num = num / base;
                bitList.add(remainder);
            }
        }
        return bitList.toArray(new Integer[]{});
    }

}