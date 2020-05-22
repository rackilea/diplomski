//...
System.out.println("Enter withdrawal: ");
int withdrawal = in.nextInt();
if (withdrawal > initialAccountBalance)
    throw new InsufficientFundsException();
double balance = initialAccountBalance - withdrawal;
System.out.printf("Account Balance: %8.2f", balance);
//...