public static String decode(final String st) {
    final StringBuilder sb = new StringBuilder();

    final char[] chars = st.toCharArray();

    int i = 0;
    while (i < chars.length) {
        int repeat = 0;
        while ((i < chars.length) && Character.isDigit(chars[i])) {
            repeat = repeat * 10 + chars[i++] - '0';
        }
        final StringBuilder s = new StringBuilder();
        while ((i < chars.length) && !Character.isDigit(chars[i])) {
            s.append(chars[i++]);
        }

        if (repeat > 0) {
            for (int j = 0; j < repeat; j++) {
                sb.append(s.toString());
            }
        } else {
            sb.append(s.toString());
        }
    }

    return sb.toString();
}

@Test
public void test() {
    Assert.assertEquals("abb", decode("1a2b"));
    Assert.assertEquals("aaaaaaaaaa", decode("10a"));
    Assert.assertEquals("baaaaaaaaaa", decode("b10a"));
    Assert.assertEquals("abab", decode("2ab"));
    Assert.assertEquals("Heeeeeeeeeeeellooooo", decode("H9e3e2l5o"));
}