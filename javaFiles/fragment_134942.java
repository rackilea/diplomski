String dateString = "Mon Nov 23 2015 08:00:00";

try {

     DateFormat readFormat = new SimpleDateFormat( "EEE MMM dd yyyy HH:mm:ss", Locale.UK);
     Date date = readFormat.parse(dateString);
     return date;

    } catch (ParseException e) {
      Log.e("Error", e.getMessage());
      return null;
    }