public static void main(String[] args) 
{
    Integer[] exclude = {1, 4, 7};

    for(int i= 0 ; i < 10; i++)
    {
       if(!Arrays.asList(exclude).contains(i))
       {
           System.out.println(i);
       }
    }
}