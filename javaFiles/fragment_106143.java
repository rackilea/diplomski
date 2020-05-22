// Rows (each week)
    LocalDate localDate = yearMonth.atDay( 1 ).with( TemporalAdjusters.previousOrSame( firstDayOfWeek ) );
    while ( ! localDate.isAfter( yearMonth.atEndOfMonth() ) )  // "Not after" is a shorter way of saying "is equal to or sooner than".
    {
        for ( int i = 0 ; i < 7 ; i++ )
        {
            // If we want to suppress the out-of-month dates that may exist in first and last rows.
            if ( ! YearMonth.from( localDate ).equals( yearMonth ) )
            {
                sb.append( "  " );  // Use 2 spaces rather than 2 digits of day-of-month number.
            } else  // Else the date is inside our target year-month.
            {
                sb.append( localDate.format( CalendarMaker.DAY_FORMATTER ) );
            }
            if ( i < 6 )
            {
                sb.append( " " ); // Pad with a SPACE between columns.
            }
            localDate = localDate.plusDays( 1 );  // Increment one day at a time.
        }
        sb.append( this.eol );
    }