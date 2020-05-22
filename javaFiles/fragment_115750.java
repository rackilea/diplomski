public static void main(String args [])
    {
       Scanner sc= new Scanner (System.in);
       int x, y ;

       System.out.println("Student 1 please enter your mark: ");
       x= sc.nextInt();

       System.out.println("Student 2 please enter your mark: ");
       y=sc.nextInt();

       compareMarks (x, y);
    }

    public static void compareMarks (int x, int y)
    {
      if (x>100 || y>100)
      {
         System.out.println("Invalid mark!! the marks has to be between 0-100");
      }
      else if (x<y)
      {
         System.out.println("Student 2 has higher mark than Student 1");
      }
      else 
      {
         System.out.println("Student 1 has higher mark than Student 2");
      }
   }