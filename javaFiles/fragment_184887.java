ArrayList<String> keys = new ArrayList<String>();
    keys.add("username");
    keys.add("on");
    String startDelimiter = ":";
    String endDelimiter = ":";
    String searchStr = "A user with username :suren: logged into the system on :22 May 2013 2:30 PM:";
    for (String key : keys) {
        String pattern = "("+key+")[ ]*?"+startDelimiter+"([^" +endDelimiter+ "]+)"+endDelimiter;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(searchStr);
        while (m.find()) {
            System.out.println("Key: " + m.group(1) + " Value: "
                    + m.group(2));
        }
    }