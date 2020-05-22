public class StringToByteArray {
public static void main(String args[])
{
    String line= "[-3, 123, 89, 0, -34, 78, -45, -78]";
    String some=line.substring(1, line.length()-1);     
    int element_counter=1;

    for(int i=0; i<some.length(); i++)
    {           
        if (some.substring(i, i+1).equals(","))
        {
            element_counter++;
        }       

    }
    int [] comas =new int[element_counter-1];
    byte [] a=new byte[element_counter];
    if (a.length==1)
    {
        a[0]= Byte.parseByte(some.substring(0));
    }       
    else 
    {
        int j=0;
        for (int i = 0; i < some.length(); i++) 
        {
            if (some.substring(i, i+1).equals(","))
            {
                comas[j]=i;
                j++;
            }
        }           
        for (int i=0; i<element_counter; i++)
        {
            if(i==0)
            {
                a[i]=Byte.parseByte(some.substring(0, comas[i]));
            }
            else if (i==element_counter-1)
            {
                a[i]=Byte.parseByte(some.substring(comas[comas.length-1]+2));
            }
            else
            {
                a[i]=Byte.parseByte(some.substring(comas[i-1]+2, comas[i]));
            }

        }
    }
    System.out.println(a[0]);

}
}