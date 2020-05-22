public class Program12 {

   String str,newStr="";  
   int num;

   public void encodeDecode() throws IOException

   {

     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

          System.out.println("Input a string");

          str = br.readLine();
          str.toUpperCase();
          System.out.println("input a number");

          num = Integer.parseInt(br.readLine());
          char ch;int sum;
          for(int i=0;i<str.length();i++)
          {
              ch=str.charAt(i);
              if((ch+num)>90)
              {
                  sum=((ch+num)%90%26);
                  if(sum>0)
                      ch=(char)(sum+64);
              }
              else
              {
                  ch=(char)(ch+num);
              }
              newStr=newStr+ch;
          }
          System.out.println("entered str : "+str+" num : "+num+" newstr : "+newStr);
   }
}