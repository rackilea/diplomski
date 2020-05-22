String test = "\\connect 127.0.0.1 2345";
    Pattern p1 = Pattern.compile("^\\s*\\\\connect\\s+((\\d{1,3}\\.){3}\\d{1,3})(?:\\s+(\\d+))?\\s*$");
    Pattern p2 = Pattern.compile("^\\s*\\\\connect\\s+((?:\\d{1,3}\\.){3}\\d{1,3})(?:\\s+(\\d+))?\\s*$");

    System.out.println(p1.matcher(test).matches());
    System.out.println(p2.matcher(test).matches());