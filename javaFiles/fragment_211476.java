int iDoW = dt.getDayOfWeek();

where iDoW can take the values (from class DateTimeConstants).

public static final int MONDAY = 1;
public static final int TUESDAY = 2;
public static final int WEDNESDAY = 3;
public static final int THURSDAY = 4;
public static final int FRIDAY = 5;
public static final int SATURDAY = 6;
public static final int SUNDAY = 7;


...
 Localized versions of these methods are also available, thus
  DateTime.Property pDoW = dt.dayOfWeek();
  String strTF = pDoW.getAsText(Locale.FRENCH); // returns "Lundi", etc.