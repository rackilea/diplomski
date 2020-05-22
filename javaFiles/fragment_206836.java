import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] Num1;
        char[] Num2;
        String num1 = in.nextLine();
        String num2 = in.nextLine();
        in.close();
        Num1 = num1.toCharArray();
        Num2 = num2.toCharArray();  
        check(Num1, Num2);
    }
    static int DaQMultiplay(char[] num1,char[] num2){
        int res=0;
        if(num1.length<=1){
            int num1sd = 0;
            int num2sd = 0;
            if(num1!=null && !num1.equals("") && new String(num2).trim().length()>0){
                num1sd =Integer.parseInt(new String(num1));
            }

            if(num2!=null && !num2.equals("") && new String(num2).trim().length()>0){
                num2sd=Integer.parseInt(new String(num2));
            }
            return (num1sd*num2sd);
        }
        double len = num1.length;
        int lenl = (int) Math.ceil(len/2);
        char []ln1 = new char[lenl];
        char []rn1 = new char[(int) (len-lenl)];
        char []ln2 = new char[lenl];
        char []rn2 = new char[(int) (len-lenl)];
        for (int i = 0; i < ln1.length; i++) {
            ln1[i]=num1[i];
        }
        for (int i = 0; i < rn1.length; i++) {
            rn1[i]=num1[i+lenl];
        }
        for (int i = 0; i < ln2.length; i++) {
            ln2[i]=num2[i];
        }
        for (int i = 0; i < rn2.length; i++) {
            if(num2.length>i+lenl){
                rn2[i]=num2[i+lenl];
            }
        }

        res+=(DaQMultiplay(ln1,ln2)*(Math.pow(10, len)));
        res+=(DaQMultiplay(rn1,ln2)*(Math.pow(10, (len/2))));
        res+=(DaQMultiplay(ln1,rn2)*(Math.pow(10, (len/2))));
        res+=(DaQMultiplay(rn1, rn2));

        return res;
    }
    static void check(char []Num1,char []Num2){
        int res=0;
        if ((Num1.length%2)==0) {
            res=DaQMultiplay(Num1, Num2);
            System.out.println(res);
        }
        else{
            String num1 = String.valueOf(Num1);
            num1 = num1+"0";
            String num2 = String.valueOf(Num2);
            num2 = num2+"0";
            Num1=num1.toCharArray();
            Num2=num2.toCharArray();
            res=DaQMultiplay(Num1, Num2);
            res=(res/100);
            System.out.println(res);
        }
    }
}