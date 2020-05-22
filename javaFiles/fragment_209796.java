import java.util.Scanner;
import java.io.*;

public class example {
public static void main(String[] args){

Scanner sc = new Scanner(System.in);
String filepath = "Technician.txt";

System.out.print("Enter ID : ");
String searchTerm= sc.nextLine();



readRecord(searchTerm,filepath);
}

public static void readRecord(String searchTerm,String filepath){

try
{
Scanner x = new Scanner(new File(filepath));

while(x.hasNext())
{
  String values[] = x.nextLine().toString().split("\\|");


    if(values[0].equals(searchTerm)){
      System.out.print("ID: "+values[0]+"\n"+"Service : "+values[1]+"\n"+"First Name: "+values[2]+"\n"+"Last Name : "+values[3]+"\n" + "Salary : "+values[4]
          +"\n" + "Position : "+values[5] + "\n");
      return;
    }

}

System.out.print("ID not found");
}
catch(Exception e)
{

}

}
}