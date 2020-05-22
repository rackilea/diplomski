String exampleValue = "@ CDSFSF";

long start = System.currentTimeMillis();
for (int i = 0; i < 100000 ; i++) {
    char[] array = exampleValue.toCharArray();
    int c = 0;
    for (; c < array.length;c++) {
        if (Character.isLetter(array[c])) {
            break;
        }
    }
    exampleValue.substring(c);
}
long end = System.currentTimeMillis();
System.out.println(end - start);