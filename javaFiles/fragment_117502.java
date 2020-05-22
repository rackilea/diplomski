for (int i = 0; i < stringArray.length; i++) {
    String s = stringArray[i];
    if (s == null || s.isEmpty()) {
        integerArray[i] = new Integer(0);
    } else {
        integerArray[i] = new Integer(s.substring(0,s.indexOf(".")));
    }
}