String input = "20190310022817";
DateTimeFormatter f = DateTimeFormatter.ofPattern( "uuuuMMddHHmmss" ) ;
LocalDateTime ldt = LocalDateTime.parse( input , f ) ;

ZoneId zParis = ZoneId.of( "Europe/Paris" ) ;
ZonedDateTime zdtParis = ldt.atZone( zParis ) ;

ZoneId zNewYork = ZoneId.of( "America/New_York" ) ;
ZonedDateTime zdtNewYork = ldt.atZone( zNewYork ) ;