import java.util.Scanner;
public class Tester {
public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    String any = input.nextLine();
    String[] sArray = any.split("");
    String str1="";String str2="";String str3="";String str4="";String str5="";String str6="";String str7="";
    for(int i=0; i<sArray.length; i++){
        if(sArray[i].equals("1")){
            str1+="  #  ";
            str2+=" ##  ";
            str3+="# #  ";
            str4+="  #  ";
            str5+="  #  ";
            str6+="  #  ";
            str7+="#####";
        }
        if(sArray[i].equals("2")){
            str1+=" ##### ";
            str2+="#     #";
            str3+="      #";
            str4+=" ##### ";
            str5+="#      ";
            str6+="#      ";
            str7+="#######";
        }

    }
   System.out.println(str1);
    System.out.println(str2);
   System.out.println(str3);
 System.out.println(str4);
 System.out.println(str5);
  System.out.println(str6); System.out.println(str7);
}
}