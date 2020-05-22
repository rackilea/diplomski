Scanner sc = new Scanner(System.in);

// accept user input for N
System.out.println("Enter N");
int n = sc.nextInt();

String time;
int c = 0;

// store the DateFormat to compare the user inputs with
String time2 = "9:30";
DateFormat sdf = new SimpleDateFormat("hh:mm");
Date d2 = null;
try {
    d2 = sdf.parse(time2);
} catch (ParseException e) {
    e.printStackTrace();
}

// iterate for N times, asking for a user input N times.
for (int i = 0; i < n; i++) {
    // get user's input to parse and compare
    System.out.println("Enter Time");
    time = sc.next();
    Date d1 = null;
    try {
        d1 = sdf.parse(time);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    if (d1.after(d2))  {
        c++;
    }
}
System.out.println(c);