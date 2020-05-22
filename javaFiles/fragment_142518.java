import java.io.*;
import java.util.*;

public class NameAge {

public static void main(String[] args) throws FileNotFoundException
{
  ArrayList<String> names = new ArrayList<String>();
  ArrayList<Integer> ages = new ArrayList<Integer>();

  Scanner inFile = new Scanner(new File("stuff.txt")); 
  int i = 0; 
  while (inFile.hasNextLine()) { 
  String line = inFile.nextLine();
  Scanner lineScanner = new Scanner(line); 
  while(lineScanner.hasNext()){
  names.add(lineScanner.next());
  ages.add(lineScanner.nextInt());
  }
   System.out.println(names);
   System.out.println(ages);
  }

  int old_age = 0;
  int old_age_i = 0;
  int count = 0;
  for(int age : ages){
       if (old_age == 0)
            old_age = age;
       else
            if (old_age > age){
                 old_age = age;
                 old_age_i = count;
       count ++;}
            else continue;
  }
  String name = names.get(old_age_i);
  System.out.println(name);
  String theAge = ages.get(old_age_i);
  System.out.println(theAge);
  }
}