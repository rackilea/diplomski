String[] arr = { "s1", "s2", "s3", "s4", "s5", "s6" };

    final int L = arr.length;
    final int K = 3;
    List<String> list = new ArrayList<String>(Arrays.asList(arr));
    list.addAll(list.subList(0, K-1));

    for (int i = 0; i < L; i++) {
        System.out.println(list.subList(i, i + K));
    }