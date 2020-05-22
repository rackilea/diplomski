List< DateTimeFormatter > formatters = 
    List.of(
        DateTimeFormatter.ofPattern( "MM-dd-uuuu" ) ,  // 01-23-2019
        DateTimeFormatter.ISO_LOCAL_DATE ,             // 2019-01-23
        DateTimeFormatter.ofPattern( "uuuu/MM/dd" )    // 2019/01/23
    )
;