public String getDecimalFormattedString(String value) {

    final int lastIndex = value.length() - 1;

    if (!value.contains(".")) {
        value = value.replaceAll(",", "");
        StringBuilder builder = new StringBuilder(value);
        String reverseStr = builder.reverse().toString();
        int commaCount = 0;
        for (int i = 1; i < reverseStr.length(); i++) {
            if (i % 3 == 0) {
                builder.insert(commaCount + i, ",");
                commaCount++;
            }
        }
        value = builder.reverse().toString();
        history = value;//forgot it 
    } else if (value.charAt(lastIndex) == '.' && value.indexOf('.') != lastIndex) {
        value = history;
    }

    return value;
}