// Rows (each week)
    LocalDate localDate = yearMonth.atDay( 1 ).with( TemporalAdjusters.previousOrSame( firstDayOfWeek ) ); // Get the first date of the month, then move backwards in time to determine the first date that fits our calendar grid. May be the same as the first, or may be earlier date from the previous month.
    while ( ! localDate.isAfter( yearMonth.atEndOfMonth() ) )  // "Not after" is a shorter way of saying "is equal to or sooner than".
    {
        String week =
                localDate
                        .datesUntil( localDate.plusWeeks( 1 ) )  // Get a stream of dates via `LocalDate::datesUntil`. The ending date is exclusive (half-open).
                        .map( ld -> ( YearMonth.from( ld ).equals( yearMonth ) ? ld.format( CalendarMaker.DAY_FORMATTER ) : "  " ) ) // Display the day-of-month number if within the target month, otherwise display a pair of SPACE characters.
                        .collect( Collectors.joining( " " ) );  // Separate columns with a SPACE in our calendar grid.
        sb.append( week ).append( this.eol ); // Add this row of text for the week, and wrap to next line for next loop.
        localDate = localDate.plusWeeks( 1 );  // Increment one week at a time to set up our next loop.
    }