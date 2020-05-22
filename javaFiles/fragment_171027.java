DateTimeFormatter f =  
        new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .appendValue( IsoFields.WEEK_BASED_YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2)
        .toFormatter()
;