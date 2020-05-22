import java.util.Scanner;
import java.io.*;

public class PayRoll3{
public static void main(String[] args) throws FileNotFoundException{

    Scanner input=new Scanner(new File(args[0]));  
    int size=input.nextInt();
    input.nextLine();

    Employee[] employees = new Employee[size];
    int index = 0;

    while(input.hasNext()){
        String tmp= input.nextLine();
        String[] commas = tmp.split(",");

        if(commas[0].charAt(0) == '#'){
            employes[index++] = new Manager2(commas[0].substring(1), commas[1], Double.parseDouble(commas[2]));
        }
        else if (commas[0].charAt(0) == '*'){
            employes[index++] = new ComissionEmployee2(commas[0].substring(1), commas[1], Double.parseDouble(commas[2]), Double.parseDouble(commas[3]), Double.parseDouble(commas[4]));
        }
        else if (commas[0].charAt(0) == '@'){
        employes[index++] = new HourlyWorkey2(commas[0].substring(1), commas[1], Double.parseDouble(commas[2]), Double.parseDouble(commas[3]));
        }

    }

    input.close();

    for (Employee currentEmployee : employees ){
        System.out.println( currentEmployee );
    }