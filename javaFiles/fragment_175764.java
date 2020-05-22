TimeZone tzAlgiers = TimeZone.getTimeZone("Africa/Algiers");
TimeZone tzBahrain = TimeZone.getTimeZone("Asia/Bahrain");

SimpleDateFormat fmtTimeAlgiers = new SimpleDateFormat("HH:mm:ss");
fmtTimeAlgiers.setTimeZone(tzAlgiers);

SimpleDateFormat fmtDatetimeAlgiers = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
fmtDatetimeAlgiers.setTimeZone(tzAlgiers);

SimpleDateFormat fmtFullAlgiers = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z (Z)");
fmtFullAlgiers.setTimeZone(tzAlgiers);

SimpleDateFormat fmtFullBahrain = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z (Z)");
fmtFullBahrain.setTimeZone(tzBahrain);

Date date1970 = fmtTimeAlgiers.parse("09:44:00");
System.out.println(fmtTimeAlgiers.format(date1970) + "                          " + tzAlgiers.getID());
System.out.println(fmtFullAlgiers.format(date1970) + "   " + tzAlgiers.getID());
System.out.println(fmtFullBahrain.format(date1970) + "   " + tzBahrain.getID());
System.out.println();

Date date2016 = fmtDatetimeAlgiers.parse("2016-01-01 09:44:00");
System.out.println(fmtDatetimeAlgiers.format(date2016) + "               " + tzAlgiers.getID());
System.out.println(fmtFullAlgiers.format(date2016) + "   " + tzAlgiers.getID());
System.out.println(fmtFullBahrain.format(date2016) + "   " + tzBahrain.getID());
System.out.println();