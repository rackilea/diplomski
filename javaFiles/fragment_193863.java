SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
Date date = null;
try {
    date = formatter.parse(input);
    System.out.println(formatter.format(date));
} catch (ParseException e) {
    e.printStackTrace();
}