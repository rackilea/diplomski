for (int j = 0; j < str.length; j++) {
    String temp = "";
    for (int i = j; i < str.length; i++) {
        if ("".equals(temp))
            temp = str[i]; // assign the String to temp, but do not add to list yet
        else {
            temp = temp + " " + str[i];
            list.add(temp); // now that temp consists of at least two elements
                            // add them to the list
        }
    }
}