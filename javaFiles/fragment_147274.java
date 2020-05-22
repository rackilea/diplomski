// Note, MM is months, not mm
DateFormat outputFormat = new SimpleDateFormat("MM/yyyy", Locale.US);
DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US);

String inputText = "2012-11-17T00:00:00.000-05:00";
Date date = inputFormat.parse(inputText);
String outputText = outputFormat.format(date);