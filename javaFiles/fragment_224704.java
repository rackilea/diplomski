double value = 0.0;

  Scanner input = new Scanner(System.in);

     System.out.print("\nEnter a number: ");
     while(input.hasNext())
     {
        while(input.hasNextDouble())
        {
           value = input.nextDouble();
        }

        String next = input.next();

        if("c".equals(next))
        {
           //do something
        }
        else if("q".equals(next))
        {
           //do something
        }
        else
        {
           System.out.print("\nInvalid Input");
           //return or throw exception

        }
     }