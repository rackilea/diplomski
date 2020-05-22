String inputDueDateRaw = "2014-05-09 11:36:41.816"
String inputDueDate = inputDueDateRaw.replace( " ", "T" );
DateTimeZone timeZone = DateTimeZone.forID( "Europe/Paris" );
DateTime due = new DateTime( inputDueDate, timeZone );  // Note the time zone by which to interpret the parsing of the string.
DateTime dayBeforeDue = due.withTimeAtStartOfDay().minusDays( 1 ).withTimeAtStartOfDay();
DateTime dayAfterDue = due.withTimeAtStartOfDay().plusDays( 1 ).withTimeAtStartOfDay(); // Half-open. Up to but not including day after.
Interval renewalInterval = new Interval( dayBeforeDue, dayAfterDue );