public static void main(String[] args)
{
    Scanner kbd = new Scanner(System.in);

    String code, decision;
    int price = 0;
    double residential, commercial, multidwelling;
    boolean yesno = true;
    boolean repeat = true;
    boolean cde = true;
    double total = 0;
    boolean yn = true;
    double prop = 0;
    double commission = 0;
    System.out.println("Real-estate Commission Calculator");
    System.out.println("----------------------------------");
    while (yn)
    {

        while (repeat)
        {
            System.out.print("Enter property's selling price: ");
            price = kbd.nextInt();
            if (price <= 0)
            {
                System.out.println("**error**selling price must be greater than zero ");
                repeat = true;
            }
            else
            {
                prop = prop + price;
                while (cde)
                {
                    System.out.println("residential         R\nmulti-dwelling     M\nCommercial           C");
                    System.out.println("Enter property code: ");
                    code = kbd.next();
                    switch (code)
                    {
                    case "r":
                        residential = price * 0.07;
                        cde = false;
                        total = +residential;
                        break;

                    case "m":
                        multidwelling = price * 0.06;
                        cde = false;
                        total = +multidwelling;
                        break;

                    case "c":
                        commercial = price * 0.035;
                        cde = false;
                        total = +commercial;
                        break;

                    default:
                        System.out.println("**error**- Property code must be R,M,C");
                        cde = true;
                        break;
                    }
                    commission = commission + total;
                }
            }
            cde = true;
            break;
        }
        System.out.println("Do u want to calculate another commission(y or n): ");
        decision = kbd.next();
        switch (decision)
        {
        case "y":
            yn = true;
            break;

        case "n":
            System.out.println("*********Transacction Summary************");
            System.out.println("Total Property Sale: " + prop);
            System.out.println("Total Commissions: " + commission);
            yn = false;
            break;

        default:
            System.out.println("**Error**Enter valid response");
            yesno = true;
            while (yesno)
            {
                System.out.println("do you want to calculate another commsion(y or n):");
                decision = kbd.nextLine();
                switch (decision)
                {
                case "y":
                    yn = yesno = true;
                    break;

                case "n":
                    yn = yesno = false;
                    break;
                }
            }
        }
    }
    kbd.close();
}