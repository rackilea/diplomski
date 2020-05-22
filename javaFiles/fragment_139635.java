final public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the strings:->");
        String str=br.readLine();

        String strArr[]=str.split(" ");

        String temp;                                    

        for(int i = 0; i<strArr.length - 1; i++)        
        {                                               
            for(int j = 0; j<strArr.length - 1; j++) 
            {                                           
                if(strArr[j].compareTo(strArr[j+1]) > 0)
                {                                       
                    temp = strArr[j];                    
                    strArr[j] = strArr[j+1];              
                    strArr[j+1] = temp;                  
                }                                       
            }
        }

        for(int i=0;i<strArr.length;i++)
        {
            System.out.println(strArr[i]);
        }
    }
}