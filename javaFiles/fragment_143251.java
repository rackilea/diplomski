String string = currentDatasetBundle.dataset.created_at;
SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ",Locale.GERMANY);
Date date;

String output = null;
try {
    date = inFormat.parse(string);
    output = android.text.format.DateFormat.getDateFormat(getContext()).format(date)
        + " " + android.text.format.DateFormat.getTimeFormat(getContext());
} catch (ParseException e) {
    e.printStackTrace();
}
dateLabel.setText(output);