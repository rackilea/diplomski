SimpleDateFormat englishUtcDateFormat(String format) {
    SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    return sdf;
}

SimpleDateFormat input = englishUtcDateFormat("ddMMyyyy");
SimpleDateFormat output = englishUtcDateFormat("dd/MM/yyyy");
System.out.println(output.format(input.parse("02122012"))); // 02/12/2012