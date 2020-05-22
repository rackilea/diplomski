public void banking()
{
    while(true)
    {
    Scanner scan3 = new Scanner(System.in);
    System.out.println("1:Deposit   2:Withdraw  3:Quit");
    int request = scan3.nextInt();

    Scanner scan4 = new Scanner(System.in);
    System.out.println("please enter the name for the account"); //takes the name of the account to select the correct object in arraylist
    String accountName = scan4.nextLine();

    for(Account y: accounts)                                    //for all the objects in the arraylist...
    {
        if(accountName.equalsIgnoreCase(y.getName()))
        {
            if(request == 1)
                {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("please make a deposit");
                    double newBalance = scan.nextDouble();
                    y.deposit(newBalance);
                }

            else if (request == 2)
                {
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("please make a withdrawl");
                    double withdrawl = scan2.nextDouble();

                    if(withdrawl > y.getBalance())
                        {
                            System.out.println("Insufficient funds");
                        }
                    else
                        {
                            y.withdraw(withdrawl);
                        }


                }

            else if (request == 3)
                {
                   break;
                }
        }
    }
    }
}