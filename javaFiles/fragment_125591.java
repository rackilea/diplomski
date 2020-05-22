Date date = null;
try {
    Date date = dateFormat.parse(v);
} catch(ParseException e) {
    SimpleDateFormat simplierFormat = new SimpleDateFormat("yyyy-MM-dd");
    date = simplierFormat.parse(v);
}
return date;