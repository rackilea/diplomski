public static void change(char[] front,char[] back,int len)
   {
       int count =0;
       for(int i =0;i<len;i++)
       {
           if(front[i] != back[i] )
            {
                char great = findGreatest(front[i],back[i]);
                if(great == back[i])
                    {
                count += (back[i] - front[i]);
                }
               else 
                   {
                   count += (front[i] - back[i]);
               }
            }
        }
        System.out.println(count);
   }
   public static char findGreatest(char first,char second)
    {
      int great = first;
      if(first < second)
          {
          great = second;
      }
    return (char)great;
    }