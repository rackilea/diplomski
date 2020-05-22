public static void main(String[] args) throws ParseException {
    String input = "20130401100000[-03:EST]";

    DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss'['Z':'z']'");
    df.setTimeZone(TimeZone.getTimeZone("GMT"));    

    System.out.println(df.format(new Date()));
    input = input.replace(":","00:");
    System.out.println(df.parse(input));
}