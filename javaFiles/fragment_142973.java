public static void usingSplit(String str) {
    String[] arr = str.split("(?<=\\G..)");
    List<String> list = Arrays.asList(arr);
}

public static void usingLoop(String str) {
    List<String> list = new ArrayList<String>();
    for (int i = 0; i < str.length(); i += 2) {
        list.add(str.substring(i, i + 2));
    }
}

// Warm up JVM
    for (int i = 0; i < 1000000; ++i) {
        usingSplit(str);
    }
    for (int j = 0; j < 1000000; j++) {
        usingLoop(str);
    }

    long nano = System.nanoTime();
    for (int i = 0; i < 1000000; ++i) {
        usingSplit(str);
    }
    System.out.println("Time with usingSplit(): " + (System.nanoTime() - nano) * 1.0 / Math.pow(10, 9) + " Seconds");

    nano = System.nanoTime();
    for (int j = 0; j < 1000000; j++) {
        usingLoop(str);
    }
    System.out.println("Time with usingLoop(): " + (System.nanoTime() - nano) * 1.0 / Math.pow(10, 9) + " Seconds");