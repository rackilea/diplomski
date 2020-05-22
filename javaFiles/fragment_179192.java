DateTime dtISO = new DateTime(2014, 1, 9, 0, 0, 0, 0);
DateTimeZone tzSAUDI_ARABIA = DateTimeZone.forID("Asia/Riyadh");
DateTime dtIslamic = 
  dtISO.withChronology(
    IslamicChronology.getInstance(
      tzSAUDI_ARABIA, 
      IslamicChronology.LEAP_YEAR_15_BASED));
System.out.println(dtIslamic);