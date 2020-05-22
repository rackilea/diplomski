package cloneCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class cloneCounter {
public String name;
public int age;
public double weight;

cloneCounter(String cloneName, int timeSpentLiving, double heaviness)
{
name = cloneName;
age = timeSpentLiving;
weight = heaviness;

}

public static void main(String[] args) {



//This is what the textfile looks like.
//Billy 22 188.25
//Sam 46 301.77
//John 8 51.22      

//code that can read and print the textfile
String fileName = "data.txt";
Scanner inputStream = null;
System.out.println("The file " + fileName + "\ncontains the following lines:\n");
try
{
  inputStream = new Scanner(new File("data.txt"));//The txt file is being read correctly.
}
catch(FileNotFoundException e)
{
  System.out.println("Error opening the file " + fileName);
  System.exit(0);
}


List<cloneCounter> clones = new ArrayList<cloneCounter>();     
while (inputStream.hasNextLine()) {
               String line = inputStream.nextLine();
               String[] data = line.split(" ");
               cloneCounter clone = new cloneCounter(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2]));
               clones.add(clone);
           }

   inputStream.close();






for(int i=0; i<3; i++)
{
    System.out.println(clones.get(i).name + " " + clones.get(i).age + " " +    clones.get(i).weight);
}

}

}