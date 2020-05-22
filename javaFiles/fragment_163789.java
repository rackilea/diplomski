import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter; 
import java.io.Writer;


public class OrderedFood extends Food {

private int quantity;
private boolean isSet;
private SetDrink setDrink;


public OrderedFood(){
    quantity =  0;
    isSet = false;
    setDrink = null;
}

public OrderedFood(String foodCode, String foodName,boolean isSet, SetDrink    setDrink, int quantity){
    super(foodCode, foodName);
    this.isSet = isSet;
    this.quantity = quantity;
    this.setDrink = setDrink;
} 

public int  getquantity(){
    return quantity;
}

public void setquantity(int quantity){
    this.quantity = quantity;
}

public boolean getIsSet(){
    return isSet;
}
public void setisSet(boolean isSet){
    this.isSet = isSet;
}
public SetDrink getsetDrink(){
    return setDrink;
}
public void setsetDrink(SetDrink setDrink){
    this.setDrink = setDrink;
}

public void addItem (String foodCode, int TabNum)throws IOException{ 
    clearScreen();  // invoking the clearScreen method


    String filename = Integer.toString(TabNum); 
    try
    {
        //this blocks creates a table by the table num
        File file = new File("/tmp", filename);     
        System.out.println("path=" + file.getAbsolutePath());
        file.createNewFile();
        filename = file.getAbsolutePath(); //here the actual address is updated to use later

        System.out.println("File created");
    }
    catch(Exception e)  
    {
        e.printStackTrace();
        System.out.println("Failed to create file");
    }
    try
    {
      //now here we need that address updated earlier not just the tabnumber
      PrintWriter writer = new PrintWriter(filename, "UTF-8");
      writer.print("food code");
      riter.close();
    }

}
public void deleteItem(String foodCode , int TabNum)throws IOException{
    clearScreen();

    String Tab = Integer.toString(TabNum);

    remove(Tab,foodCode);// we just invoke the remove method, which will then remove the item from the .txt file   
}


public static void clearScreen() {  // this method clears the screen.
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }  


 public void remove(String file, String lineToRemove)throws IOException { 

        try {

            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader buff = new BufferedReader(new FileReader(file));
            PrintWriter kap = new PrintWriter(new FileWriter(tempFile));

            String line = null;


            while ((line = buff.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    kap.println(line);
                    kap.flush();
                }
            }
            kap.close();
            buff.close();

            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
      }

   }