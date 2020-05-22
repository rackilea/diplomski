method (new Object[] {f, s});

void method (Object o) {
    final Object[] arr = (Object[]) o;
    File f = (File) arr[0];
    String s = (String) arr[1];
}