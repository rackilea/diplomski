java.time.LocalDate targetLocalDate = LocalDate.of( 2014, 8, 15 );
// OR… LocalDate target = LocalDate.parse( "2014-08-15" );
LocalDate localDatePicked = datePicker.getValue();
if ( localDatePicked.equals( targetLocalDate ) 
{
    System.out.println("Success!!!");
}