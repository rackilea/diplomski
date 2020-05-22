String server_format = "2013-08-19T14:29Z";    //server comes format ?
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
try {

    Date date = sdf.parse(server_format);
    System.out.println(date);
    String your_format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    String [] splitted = your_format.split(" ");
    System.out.println(splitted[1]);    //The second part of the splitted string, i.e time
    // Now you can set the TextView here


} catch (ParseException e) {
    System.out.println(e.toString()); //date format error
}