String input = 
        "30-11-2013 ;30-11-2013 ;SUMMARY ;0.0 ;200.0 ;2800.0 ;2800.0\r\n"
        + "31-12-2013 ;31-12-2013 ;SUMMARY ;0.0 ;200.0 ;3000.0 ;3000.0\r\n"
        + "02-01-2014 ;02-01-2014 ;TRANSF ;0.0 ;300.0 ;3300.0 ;3300.0\r\n"
        + "x02-01-2014 ;02-02-2014 ;TRANSF ;0.0 ;300.0 ;3600.0 ;3600.0\r\n"
        + "03-01-2014 ;03-01-2014 ;TRANSF ;0.0 ;300.0 ;3900.0 ;3900.0";
Scanner scanner = new Scanner(input);

Pattern pattern = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}",
        Pattern.MULTILINE);
while (scanner.hasNext(pattern)) {
    System.out.println(scanner.nextLine());
}