package bpunit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Read_ini {
    public void Read_ini_toObject() 
    {
    String csvFileToRead = "configs/BPUnit.properties";
    BufferedReader br = null;
    String line;
    String splitBy = ",";
    List<ButtonConfig> buttonList = new ArrayList<ButtonConfig>();

    try {

        br = new BufferedReader(new FileReader(csvFileToRead));
        while ((line = br.readLine()) != null) {

            // split on comma(',')
            String[] buttonconfig = line.split(splitBy);

            // create button object to store values
            ButtonConfig buttonObject = new ButtonConfig();

            // add values from csv to car object
            buttonObject.setKeyword(buttonconfig[0]);
            buttonObject.setGponumber(buttonconfig[1]);
            buttonObject.setButtontype(buttonconfig[2]);
            buttonObject.setLanguage(buttonconfig[3]);
            buttonObject.setFilename(buttonconfig[4]);
            buttonObject.setExtension(buttonconfig[5]);
            // adding button object to a list
            buttonList.add(buttonObject);

        }
        // print values stored in buttonList
        printButtonList(buttonList);

        } catch (FileNotFoundException e) {
           System.out.print(e);
        } catch (IOException e) {
           System.out.print(e);
        } finally {
           if (br != null) {
               try {
                   br.close();
               } catch (IOException e) {
                   System.out.print(e);
               }
           }
       }
    }

    public void printButtonList(List<ButtonConfig> buttonListToPrint) {
        for (int i = 0; i < buttonListToPrint.size(); i++) {            

        // THE LINE BELOW FAILS - getExtension() does not exist 
        // and all other attempts give me pointer references 
        //instead of the text //

            System.out.println(buttonListToPrint.get(i).getExtension());        

           }
      } 

   }