import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class Testing1 {
   public static void main(String[] args)throws InputMismatchException
   {
      if(args.length == 0)
      {
            //This prompt will show when no input detected on the command line arguments.
         System.out.println("Please input the file name.");
      }
      else
      {
         ArrayList<Integer> array = Testing1.readFileReturnIntegers(args[0]);
         Testing1.printArrayAndIntegerCount(array, args[0]);
      }
   }// end of main

   public static ArrayList<Integer> readFileReturnIntegers(String inputData)
   { 
      ArrayList<Integer> listOfIntegers = new ArrayList<Integer>(); 
      int count = 0;

      File data = new File(inputData);
      Scanner inputReader = null;
      try 
      {
               //This will create a connection to the file.
         inputReader = new Scanner(data);
      } 
      catch (FileNotFoundException exception)
      {
                   //This message will appear when the text file entered doesn't exist.
         System.out.print("ERROR: File not found for: \"");
         System.out.println(inputData+ "\"");
      } 
            //If the text file does exist, it will go through the file.
      if (inputData != null)
      {
         System.out.print("number of integers in file " + " \"");
         System.out.println(inputData + "\"");
                  while (inputReader.hasNextLine())
         {
            try
            {  
                   //reads an integer in a line of text       
               Integer element = inputReader.nextInt();
               listOfIntegers.add(element);
                    //prints out the integer and and its index in the array
               System.out.println("index = " + count + ", element = " + element);
               count ++;
            }
            catch (InputMismatchException e)
            {
               String word = inputReader.next();
            }
            catch (NoSuchElementException e)
            {
                      //to avoid program crashing against this exception.
            }
         }//end of while
      }

      return listOfIntegers;             
   }//end of readFileReturnIntegers

   public static void printArrayAndIntegerCount(ArrayList<Integer> array, String filename)
   {  
      System.out.print("\nTotal number of integers in file: " + " \"");
      System.out.println(filename + "\"" + " = " + array.size());

   }//end of printArrayAndIntegerCount

}//end of class