String line = "Ticket Order 3748594 / 45 : blablabla";
    String pattern = "[0-9]{5,}"; //this means at least 5 length of digits

    // Create a Pattern object
    Pattern r = Pattern.compile(pattern);

    // Now create matcher object.
    Matcher m = r.matcher(line);

    if (m.find( )) {
        System.out.println("Found value: " + m.group(0) );
    }else {
        System.out.println("NO MATCH");
    }