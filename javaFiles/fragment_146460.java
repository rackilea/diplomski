public static void main(String[] args) {

    long originalTime = 0;
    long deleteTime = 0;
    long substringTime = 0;

    for (int i=0; i<100; i++) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for (int j=0; j<10000; j++) {
            sb1.append(" ");
            sb2.append(" ");
            sb3.append(" ");
        }
        for (int j=0; j<980000; j++) {
            sb1.append("a");
            sb2.append("a");
            sb3.append("a");
        }
        for (int j=0; j<10000; j++) {
            sb1.append(" ");
            sb2.append(" ");
            sb3.append(" ");
        }

        long timer1 = System.currentTimeMillis();
        trimOriginal(sb1);
        originalTime += System.currentTimeMillis() - timer1;

        long timer2 = System.currentTimeMillis();
        trimDelete(sb2);
        deleteTime += System.currentTimeMillis() - timer2;

        long timer3 = System.currentTimeMillis();
        trimSubstring(sb3);
        substringTime += System.currentTimeMillis() - timer3;
    }

    System.out.println("original:  " + originalTime + " ms");
    System.out.println("delete:    " + deleteTime + " ms");
    System.out.println("substring: " + substringTime + " ms");
}