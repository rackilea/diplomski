List<String> times = Arrays.asList("2017-06-07", "2017-06-08","2017-06-09","2017-06-10","2017-06-11");
System.out.println("from         to");
String prev = null;
for (String date : times) {
    if (prev != null)
        System.out.println(prev + "   " + date);
    prev = date;
}