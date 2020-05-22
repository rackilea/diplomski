@Test
public void successive() {
    char[] a = new char[]{'a', 'b', 'x', 'z', 'y'};
    char[] b = new char[]{'r', 's', 't', 'a', 'b'};
    boolean isSuccessive = false;
    for (int i = 0; i < a.length - 1; i++) {
        for (int j = 0; j < b.length - 1; j++) {
            if (a[i] == b[j] && a[i + 1] == b[j + 1]) {
                isSuccessive = true;
            }
        }
    }
    assertTrue(isSuccessive);
}