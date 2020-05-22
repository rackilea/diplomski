import java.io.*;
import java.util.*;

public class Testing
{
    public static void main (String [] args) throws FileNotFoundException
    {
        int i=0,j,k,map_addr;
        String [] inp_value = new String[100];
        String [] inp_addr_val = new String[100];
        String [] inp_addr = new String[100];
        String addr_path,sCurrentLine;
        BufferedReader reader = null;
        Scanner inp = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        Iterator map_iterator = map.keySet().iterator();


        System.out.println("Welcome! Please enter the addresses");

        while(i!=100)
        {
            System.out.println("Enter address:");
            inp_addr[i] = inp.nextLine();
            try 
            {
                reader = new BufferedReader(new FileReader(inp_addr[i]));

                while ((sCurrentLine = reader.readLine()) != null) 
                {
                      inp_value[i]=reader.readLine();
                      inp_addr_val[i]=Integer.toString(i);
                      map.put(inp_addr_val[i],inp_value[i]);
                      i++;
                      System.out.println(map.get(inp_addr_val[i-1]));


                }
                         for(j=0;j<=i;j++)
                          {
                              if(inp_value[j].equals(inp_value[i-1]))
                              {
                              System.out.println("File already exists, skipping this file.");
                              i--;

                              }
                          }

            }catch (IOException ex) {
                ex.printStackTrace();
                /*System.out.println("Something bad happened. Program is exiting now...");
                System.exit(0);*/

            }





    }
    }}