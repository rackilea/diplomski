import java.io.*;
import java.util.*;
import java.lang.Math.*;
import java.sql.*;

/**
 *
 * @author Soumen
 */
public class Edgelist {

    private static int getRandomNumberInRange(int min, int max)
    {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
  public static void main(String args[]) throws Exception
    {

        FileInputStream f=null;
        int i,c=0,v1_chck=0,v2_chck=0;
        String num="";

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
            Statement stmt=con.createStatement();
            String s=null,ver1=null,ver2=null;
            int serial=0,type;




        try
        {
            f=new FileInputStream("F:\\College Project\\dolphin.txt");
            do
            {
                i=f.read();
                if(i!=-1)
                {
                    if((char) i !=' ' && (char) i !='\n' && (char) i !='\r')
                    {
                        num=num+(char) i;
                    }
                    else
                    {
                        if((char) i == ' ') 
                        {
                            ver1=num;
                            v1_chck=1;
                            num="";
                        }
                        else
                        {
                            if((char) i == '\n')
                            {
                                ver2=num;
                                v2_chck=1;
                                num="";
                            }
                        }
                    }
                    if(v1_chck==1 && v2_chck==1)
                    {
                        ++serial;
                        type=getRandomNumberInRange(1, 10);

                        s="insert into edges(serial_no, vertex1, vertex2, edge_type)"
                          +"values("+serial+", '"+ver1+"', '"+ver2+"', "+type+")";
                        stmt.executeQuery(s);


                        v1_chck=0;
                        v2_chck=0;
                    }

                }
            }while(i!=-1);
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        finally 
        {
            try
            {
                if(f != null)
                    f.close();
                con.commit();
                con.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }


    }
}