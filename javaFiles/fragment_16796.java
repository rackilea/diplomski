@Test
public void testArray() {
    String[] strArray = {"hello", "world", "bye"};

    System.out.println(singleQuoteAndComma(strArray));
}

private String singleQuoteAndComma(String[] strArray) {
    String in = "";
    for (int i = 0; i < strArray.length ; i++) {
        in += "'" + strArray[i] + "'";
        if (i != strArray.length - 1) {
            in += ",";
        }
    }
    return in;
}