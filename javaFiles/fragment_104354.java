System.out.println("Adjust Invoices");
System.out.println("Would like to Pay an invoice or Add an invoice to your account?");

int invoice;
do
{
    System.out.println("Press '1' to Pay and '2' to Add");
    invoice = choice.nextInt();
    if (invoice == 1)
    {
        System.out.println("one");
        break;
    }
    if (invoice == 2)
    {
        System.out.println("two");
        break;
    }
} while (true);