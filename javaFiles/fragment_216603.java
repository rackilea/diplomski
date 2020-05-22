new Date().previous().clearTime().toCalendar().with { cal ->
    println format( "yyyy-MM-dd HH:mm:ss" )
    add( Calendar.DAY_OF_YEAR, 1 )
    add( Calendar.SECOND, -1 )
    println format("yyyy-MM-dd HH:mm:ss")
}