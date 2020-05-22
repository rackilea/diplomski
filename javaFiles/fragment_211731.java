import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ClosestPoint
{
    public static void main (String[] args)
    {

        Scanner in = new Scanner(System.in);
        String line;
        boolean done=false;
        String error=null;
        List<PointName> points=new ArrayList<PointName>();

        do
        {
            System.out.println("Enter a new point in this format: name:x,y");
            line=in.nextLine();
            done=line.equals("");
            if(!done) //Empty line terminates the loop
            {
                String [] parts=line.split(":");
                if(parts.length==2)
                {
                    String name=parts[0];
                    parts=parts[1].split(",");
                    if(parts.length==2)
                    {
                        try
                        {
                            PointName pn=new PointName(name,Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
                            points.add(pn);
                        }
                        catch(NumberFormatException ex)
                        {
                            error=ex.getMessage();
                        }
                    }else error="Invalid format";
                }else error="Invalid format";
            }
            if(!done) done=error!=null; //If there was an error exit the loop
        }while(!done); //Keep going until something sets the done flag
        if(error!=null)
        {
            System.out.println("Error: "+error);
        }
        else
        {
            //The points are all stored in the points List object now - this just iterates through and prints them out
            System.out.println("Here are the points you entered:");
            for(PointName pn : points)
            {
                System.out.println(pn.toString());
            }
        }
    } 
}