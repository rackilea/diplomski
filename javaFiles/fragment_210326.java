String inputYear = "90";
String inputMonth = "12";
String inputDayOfMonth = "6";

int year = Integer.parseInt( inputYear );
int month = Integer.parseInt( inputMonth );
int dayOfMonth = Integer.parseInt( inputDayOfMonth );

if( year < 100 ) { // If two-digit year, assume the 1900s century. Even better: Never generate two-digit year text!
    year = ( year + 1900 );
}

LocalDate localDate = LocalDate.of( year , month , dayOfMonth );