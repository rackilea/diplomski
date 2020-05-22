package javaapplication13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JavaApplication13 {

  public static void main(String[] args) {
    // TODO code application logic here
    BufferedReader br;
    String strLine;
    ArrayList<String> arr =new ArrayList<>();
    HashMap<Integer,ArrayList<String>> hm = new HashMap<>();
    try {
        br = new BufferedReader( new FileReader("words.txt"));
        while( (strLine = br.readLine()) != null){
            arr.add(strLine);
        }
    } catch (FileNotFoundException e) {
        System.err.println("Unable to find the file: fileName");
    } catch (IOException e) {
        System.err.println("Unable to read the file: fileName");
    }


    ArrayList<Integer> lengths = new ArrayList<>(); //List to keep lengths information 


    System.out.println("Total Words: "+arr.size()); //Total waords read from file

    int i=0;
    while(i<arr.size()) //this loop will itrate our all the words of text file that are now stored in words.txt
    {
        boolean already=false;
        String s = arr.get(i);
        //following for loop will check if that length is already in lengths list.
        for(int x=0;x<lengths.size();x++)
        {
            if(s.length()==lengths.get(x))
                already=true;
        }
       //already = true means file is that we have an arrayist of the current string length in our map
        if(already==true)
        {

            hm.get(s.length()).add(s); //adding that string according to its length in hm(hashmap)
        }
        else
        {
                hm.put(s.length(),new ArrayList<>()); //create a new element in hm and the adding the new length string
                hm.get(s.length()).add(s);
                lengths.add(s.length());

        }

        i++;
    }
    //Now Print the whole map
    for(int q=0;q<hm.size();q++)
    {
        System.out.println(hm.get(q));
    }
  }

}