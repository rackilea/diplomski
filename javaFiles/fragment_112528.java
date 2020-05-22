public static void main(String args[]) 
    {
      int a[] = new int[5];
      int i = 0; 
      Scanner in = new Scanner(System.in);
      while(i<5)
      {
      System.out.println("Enter an integer between 1 and 100");
      a[i] = in.nextInt();
      if(a[i]>=1 && a[i]<=100) 
      {
        i++;
        System.out.println("You entered integer "+a[i-1]);
      }
      }

    }