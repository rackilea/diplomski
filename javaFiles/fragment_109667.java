import java.util.Scanner;

public class March21th {

    private static Scanner sc;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        System.out.print("Please enter a sentence to reverse: ");
        String str = sc.nextLine();
        System.out.print("Please enter nth value: ");
        int n = sc.nextInt();

        String[] strArr = str.split(" ");
        int len = strArr.length;

        String str2 = strArr[n-1];
        //System.out.println("str2: "+str2);
        String strrev2 = strArr[len-n];
        //System.out.println("strrev2: "+strrev2);

        char temp;
        char[] str2CharArr = str2.toCharArray();
        char[] strrev2CharArr = strrev2.toCharArray();
        int str2CharArrLen = str2CharArr.length;
        int strrev2CharArrLen = strrev2CharArr.length;
        //System.out.println("str2CharArrLen: "+str2CharArrLen);
        //System.out.println("strrev2CharArrLen: "+strrev2CharArrLen);

        for(int i=0,j=str2CharArrLen-1;i<str2CharArrLen/2;i++,j--) {
            temp = str2CharArr[i];
            str2CharArr[i] = str2CharArr[j];
            str2CharArr[j] =  temp;
        }
        String str2CharArrRev = String.valueOf(str2CharArr);
        //System.out.println("str2CharArr after reverse: "+str2CharArrRev);

        for(int i=0,j=strrev2CharArrLen-1;i<strrev2CharArrLen/2;i++,j--) {
            temp = strrev2CharArr[i];
            strrev2CharArr[i] = strrev2CharArr[j];
            strrev2CharArr[j] =  temp;
        }
        String strrev2CharArrRev = String.valueOf(strrev2CharArr);
        //System.out.println("strrev2CharArr after reverse: "+strrev2CharArrRev);

        strArr[n-1] = str2CharArrRev;
        strArr[len-n] = strrev2CharArrRev;
        //System.out.println("strArr[n-1]: "+strArr[n-1]);
        //System.out.println("strArr[len-n]: "+strArr[len-n]);

        String revStr = "";
        for(int i=0; i<len;i++) {
            revStr += strArr[i]+" ";
        }
        System.out.println(revStr);
    }
 }