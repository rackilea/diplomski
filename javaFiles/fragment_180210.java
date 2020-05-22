for (;;)
    {

        System.out.println ("How do you sweeten your coffee?");
        System.out.println ("1. I don't");
        System.out.println ("2. With sugar?");
        System.out.println ("3. With sweetener?");
        System.out.println ("4. Quit");

        preference = input.nextInt();

        if (preference == 1)
              nothing++; 

            else if (preference == 2)
                    sugar++;
            else if (preference == 3)
                 sweetener++;

     if (preference == 4)
        break;
    }