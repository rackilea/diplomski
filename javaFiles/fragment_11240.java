int x;
Scanner in = new Scanner (System.in);
System.out.print ("Enter a date ");
x = in.nextInt();

while (x<1520 || x>3999) // change this to "or", i.e. && --> || 
    {
        System.out.println ("Invalid Gregorian Calendar date.");
        System.out.print ("Please Input a valid Gregorian Calendar date: ");
        x = in.nextInt(); // get another number before checking conditions again
    }