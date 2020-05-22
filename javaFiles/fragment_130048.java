long msSinceEpoch = System.currentTimeMillis();

Chronology chronology = ISOChronology.getInstanceUTC() // This can be static

chronology.hourOfDay().get(msSinceEpoch);
chronology.dayOfMonth().get(msSinceEpoch);
chronology.weekOfWeek().get(msSinceEpoch);
chronology.monthOfYear().get(msSinceEpoch);
chronology.years().get(msSinceEpoch);