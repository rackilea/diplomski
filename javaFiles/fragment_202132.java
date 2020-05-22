String str = "5X3I3M3X";
StringBuilder sBuffer = new StringBuilder();
for (int i = 0; i < str.length(); ++i) {
    if (i + 1 < str.length()
            && str.charAt(i + 1) == 'X'
            && str.charAt(i) != '1'
            && Character.isDigit(str.charAt(i))) {
        int n = Character.getNumericValue(str.charAt(i));
        for (int j = 0 ; j < n; ++j) {
            sBufferTemp.append("1X");
        }
        ++i;
    } else {
        sBuffer.append(str.charAt(i));
    }
}