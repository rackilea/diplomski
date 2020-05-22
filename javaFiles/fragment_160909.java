String input = "Thu Jun 18 20:56:02 EDT 2009";
    SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
    Date date = parser.parse(input);
    SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
    String formattedDate = formatter.format(date);
    .......
    System.setOut(new PrintStream(new FileOutputStream("Data_Bank_"+formattedDate +".txt")));