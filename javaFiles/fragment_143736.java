public static void change(char[] front,char[] back,int len)
{
   int count =0;
   for(int i =0;i<len;i++)
   {
       if(front[i] != back[i] )
        {
            count += (back[i] - front[i]);
        }
    }
 System.out.println(count)
}