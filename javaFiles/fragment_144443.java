String input1 = "2017-10-20";
    LocalDate date1 = LocalDate.parse(input1);
    System.out.println("Using no formatter    input1["+input1+"]  date1 ["+date1+"]");

    String input2 = "10/20/2017";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDate date2 = LocalDate.parse(input2, formatter);
    System.out.println("Formatter MM/dd/yyyy  input2["+input2+"]  date2 ["+date2+"]");