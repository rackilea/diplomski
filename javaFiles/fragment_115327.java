import java.io.*;
public class Test{

   public static void main(String[] args)
   {
        try{
            System.out.println("Type 'R' to restart");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            if(input.equals("R"))
                restart(args);
            else
                System.out.println("You did not restart");
        }
        catch(Exception e)
            {e.printStackTrace();}

    }

    private static void restart(String[] strArr)
    {
        System.out.println("You restarted");
        main(strArr);
    }

}