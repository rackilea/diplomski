import java.util.Scanner;
public class db
{
    public static void main (String []args)
    {
    //Variables
    double mark=0, average=0, sum=0, counter=0, achievement=0, percentage=0, counterpercentage=0;

    double[][] marksTable = new double[40][8];
    //New Scanner object
    Scanner fromKeyboard=new Scanner (System.in);

for (int studentNo = 0; studentNo < 40; studentNo++)
{
     System.out.println("Enter marks for student no" +studentNo);
     sum =0 ;
     counter = 0;

for (int moduleNo = 0; moduleNo < 8; moduleNo++)
{
     System.out.println("Mark for student "+studentNo+" for module no      "+moduleNo+":");
     //Read value into variable mark
     mark = fromKeyboard.nextDouble();
     // Write mark into array
     marksTable[studentNo][moduleNo] = mark;
     //Calculations
     sum=sum+mark;
     counter=counter+1;
     if(mark >= 70) {  //***Changed***//
       counterpercentage++;
     }
}
average=sum/counter;
//Display array
for (int moduleNo = 0; moduleNo < 8; moduleNo++)
{
      System.out.println("Average for student "+studentNo+" for module no "+moduleNo+" is: "+average);
     break;
}
    if (counterpercentage >=0)  //***Changed***//
    {
        System.out.println("The number of high marks achieved for this student are: "+ counterpercentage);
    }
    else
    {
        System.out.println("No high marks obtained");
    }
}
}
}