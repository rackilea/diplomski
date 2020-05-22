ArrayList<String> contactlist = new ArrayList<String>();
    contactlist.add("Android");
    contactlist.add("tarnaka");
    contactlist.add("uppal");
    contactlist.add("Prasad");

    StringBuffer sb = new StringBuffer("");

    for (String temp : contactlist) {
        sb.append("-" + temp);
    }

    String stringToSend = sb.toString();

    MyLog.printLog("String : " + stringToSend);

    String[] rString = stringToSend.split("-");

    for (String s : rString) {
            MyLog.printLog("Names : " + s);
    }