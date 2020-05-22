import java.util.Scanner;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner input = new Scanner(System.in); 
        System.out.println ("Enter collected data:");
        String data = input.nextLine();
        input.close();
        String[] splitdata = data.split("\\s+");
        int datalength=splitdata.length;
        for (int i=0; i<datalength; i++)
        {
            if (splitdata[i].equals("1") )
                splitdata[i]="**newline**";
            else if (splitdata[i].equals("8") )
                splitdata[i]="**backspace**";
            else if (splitdata[i].equals("9") )
                splitdata[i]="**tab**";
            else if (splitdata[i].equals("13") )
                splitdata[i]="**enter**";
            else if (splitdata[i].equals("16") )
                splitdata[i]="**shift**";
            else
                System.out.println("oops!, no match for: " + splitdata[i]);
        }
        for(String s: splitdata)
        {
            System.out.println(s);
        }
    }
}