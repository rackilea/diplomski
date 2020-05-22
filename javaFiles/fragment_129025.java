String string = "06%2F27%2F2012%2C07%2F05%2F2012%2C06%2F29%2F2012"; // etc...
    String decoded = null;
    try {
        decoded = URLDecoder.decode(string, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    String[] splitString = decoded.split(",");
    for (String i : splitString) {
        System.out.println(i);
    }