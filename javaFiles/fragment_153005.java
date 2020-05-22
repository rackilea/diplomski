// Not generally a good idea to focus on integers for working with date-time, but you asked for it.
DateTime someDateTime = new DateTime( 1234567898765L, DateTimeZone.UTC );

System.out.println( "Set Value of 1234567898765L is: " + someDateTime );
System.out.println( "Year is " + someDateTime.year().getAsText( locale ) );
System.out.println( "Month is " + someDateTime.monthOfYear().getAsText( locale ) );
System.out.println( "Day of month is " + someDateTime.dayOfMonth().getAsText( locale ) );
System.out.println( "Day of week is " + someDateTime.dayOfWeek().getAsText( locale ) );
System.out.println( "Day of year is " + someDateTime.dayOfYear().getAsText( locale ) );