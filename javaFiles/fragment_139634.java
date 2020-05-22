import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

final public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the strings:->");
        String str=br.readLine();

        String strArr[]=str.split(" ");//your sentence will be split into words.
        Arrays.sort(strArr);

        for(int i=0;i<strArr.length;i++)
        {
            System.out.println(strArr[i]);
        }
    }
}