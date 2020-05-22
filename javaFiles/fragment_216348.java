Charset utf8 = Charset.forName("UTF-8");
char[] array = new char[1];
for (int reps = 0; reps < 10000; reps++) {
    for (array[0] = 0; array[0] < 10000; array[0]++) {
        int len = new String(array).getBytes(utf8).length;
    }
}