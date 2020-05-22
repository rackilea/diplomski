String userInput = "12d4-2d6+7 + d8";

Pattern p = Pattern.compile("^(?!\\d+$)(([1-9]\\d*)?[Dd]?[1-9]\\d*( ?[+-] ?)?)+$");
Matcher m = p.matcher(userInput);
boolean b = m.matches();

System.out.println(b); // true