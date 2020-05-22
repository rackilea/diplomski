Calendar cal = Calendar.getInstance();
Date today = cal.getTime();
SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
String today_formatted = formatter.format(today);
cal.add(Calendar.DATE, 30);
String today_plus30_formatted = formatter.format(cal.getTime());

String query = 
"SELECT name, birthday, birthday_date FROM user 
WHERE uid in (SELECT uid2 FROM friend WHERE uid1 = me()) 
    AND birthday_date != 'null' 
    AND birthday_date > '" + today_formatted + "'
    AND birthday_date < '" + today_plus30_formatted + "'
ORDER BY birthday_date ASC";