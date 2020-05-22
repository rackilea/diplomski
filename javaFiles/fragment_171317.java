System.out.print("Please enter any amount of cash in dollars: ");
float cash = scanner.nextFloat();
int cashInPennies = Math.round(cash*100);
System.out.println(cashInPennies);
// If you say cashInPennies = (int)(cash*100), the result will be 13503 instead of
// 13504.

int ten_dollars = cashInPennies/1000;
cashInPennies %= 1000;

System.out.println(cashInPennies);

int five_dollars = cashInPennies/500;
cashInPennies %= 500;
int dollars = cashInPennies/100;
cashInPennies %= 100;
int quarters = cashInPennies/25;
cashInPennies %= 25;
int dimes = cashInPennies/10;
cashInPennies %= 10;
int nickels = cashInPennies/5;
cashInPennies %= 5;
int pennies = cashInPennies;
System.out.println("This is equal to:\n" + ten_dollars + " ten dollar bills\n"
        + five_dollars + " five dollar bills\n"
        + dollars + " one dollar bills\n"
        + quarters + " quarters\n"
        + dimes + " dimes\n"
        + nickels + " nickels\n"
        + pennies + " pennies");