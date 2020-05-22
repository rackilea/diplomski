Date timestamp = null;

    if(string.contains(".")) {
        timestamp =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
        .parse(string);
    } else {
        timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        .parse(string);
    }

    System.out.println(timestamp);