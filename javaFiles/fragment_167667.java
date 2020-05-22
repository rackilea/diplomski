ZoneId zMontreal = ZoneId.of ( "America/Montreal" );
ZoneId zRome = ZoneId.of ( "Europe/Rome" );
ZoneId zKualaLumpur = ZoneId.of ( "Asia/Kuala_Lumpur" );

ZonedDateTime zdtMontreal = instantNow.atZone ( zMontreal );
ZonedDateTime zdtRome = instantNow.atZone ( zRome );
ZonedDateTime zdtKualaLumpur = instantNow.atZone ( zKualaLumpur );

System.out.println ( "instantNow: " + instantNow + " | zdtMontreal: " + zdtMontreal + " | zdtRome: " + zdtRome + " | zdtKualaLumpur: " + zdtKualaLumpur );