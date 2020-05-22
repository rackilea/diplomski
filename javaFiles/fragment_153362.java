import java.util.Scanner;

public class BinaryToHexa
{
    public static void main(String args[])
    {
        int binnum, rem;
        String hexdecnum="";
        int decnum=0;            

        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Binary Number : ");
        binnum = scan.nextInt();        

        // converting the number in decimal format
        int i=0;      

        while(binnum>0)
        {
            rem = binnum%10;
            binnum=binnum/10;
            decnum = decnum + (int)(rem*Math.pow(2,i));
            i++;
        }     

        // converting the number in hexadecimal format
        while(decnum>0)
        {
            rem = decnum%16;
            hexdecnum = hex[rem] + hexdecnum;
            decnum = decnum/16;
        }

        System.out.print("Equivalent Hexadecimal Value is :\n");
        System.out.print(hexdecnum);

    }
}