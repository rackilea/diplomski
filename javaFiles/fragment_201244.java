String text = "2015-01-17";
try {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd yyyy");

    Date date = sdf1.parse(text);

    System.out.println("Result==> " + sdf2.format(date));
} catch (ParseException exp) {
    exp.printStackTrace();
}