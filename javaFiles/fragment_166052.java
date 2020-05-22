int value = 1;
    String text = Integer.toString(value);
    if (text.length() < 2) {
        if (text.length() == 1) {
            text = "0:0" + text;
        } else {
            text = "0:" + text;
        }
    } else {
        text = text.substring(0, text.length() - 2) + ":" + text.substring(text.length() - 2);
    }