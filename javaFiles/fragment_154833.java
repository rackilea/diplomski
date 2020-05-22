import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArffReader{
    public static void main(String[] args){
        BufferedReader reader = null;
        try{
            String CurrentLine;
            reader = new BufferedReader(new FileReader("weather.nominal.arff"));

                int counter = 0;
                boolean check = false;
                while((CurrentLine = reader.readLine()) != null){
                    String[] SplitData = CurrentLine.split(" ");
                    //Get the relation
                    if(SplitData[0].equals("@relation")){
                    System.out.println(SplitData[1]);
                    System.out.println();
                    }
                        //Get the attribute
                        if(SplitData[0].equals("@attribute")){
                            if (check == false){
                                System.out.print(SplitData[1]); 
                            }else{
                                System.out.print(" "+SplitData[1]); 
                            }
                            check = true;

                        }
                    counter++;
                }
                System.out.println();
        }catch(IOException e){
                e.printStackTrace();
        }finally{
            try{
                if(reader != null)reader.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}