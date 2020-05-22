public class Test {
    public static void main(String [] args) 
    {
      String [] month = {"July", "August", "September", "October"};
     //   smallest(Month);
        System.out.println("The shortest word index position is " + smallest(month));
    }

    public static int smallest(String Month[]) 
    {
        String first = Month[0];
        int position=0;
        for (int i = 1 ; i < Month.length ; i++) 
        {
            if (Month[i].length()<first.length())
             {
                first = Month[i];
                position=i;
            } 
        } 
        return position;
    }

}