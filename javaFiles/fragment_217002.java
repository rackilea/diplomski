Scanner scanner = new Scanner(System.in); // create a scanner object

int year1, year2, month1, month2, day1, day2;

// promt for input
System.out.println("Enter the first date: (format -> \"Y M D\")");

// read the 1st input
year1 = scanner.nextInt(); // assuming the input is correct
month1 = scanner.nextInt();
day1 = scanner.nextInt();

// promt for input
System.out.println("Enter the second date: (format -> \"Y M D\")");

// read the 2bd input
year2 = scanner.nextInt(); // assuming the input is correct
month2 = scanner.nextInt();
day2 = scanner.nextInt();

// convert the input to days(note that the conversion is only an approximation, not every year/day has the same amount of days)
int date1 = (year1 * 365 + month1 * 30) + day1; // I'll leave the number of days in the year/month checking to you.
int date2 = (year2 * 365 + month2 * 30) + day2;

int durationdifferance = date2 - date1; // note this CAN be negative if date1 is after date2(I'll leave it to you to deside the action needed if that's true)

// convert back (this is again only an approximation)
int year = durationdifferance / 356;
int month = (durationdifferance % 365) / 30;
int day = (durationdifferance % 365) % 30;

// output the differance
System.out.println("Differance is: " + year + " " + month + " " + day);