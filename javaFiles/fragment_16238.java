Scanner kbd = new Scanner (System.in);

String decision;

boolean yn = true;
while(yn)
{
    System.out.println("please enter your name");
    String name = kbd.nextLine();

    System.out.println("you entered the name" + name );

    System.out.println("enter another name : yes or no");
    decision = kbd.nextLine();


    switch(decision)
    {
        case "yes":
            yn = true;
            break;

        case "no":
            yn = false;
            break;

        default:
            System.out.println("please enter again ");
            boolean repeat = true;

            while (repeat)
            {
                System.out.println("enter another name : yes or no");
                decision = kbd.nextLine();

                switch (decision)
                {
                    case "yes":
                        yn = true;
                        repeat = false;
                        break;

                    case "no":
                        yn = repeat = false;
                        break;
                    default:
                        repeat = true;
                }
            }
            break;
    }
}