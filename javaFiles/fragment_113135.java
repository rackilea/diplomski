Scanner scanner = new Scanner(System.in);
    int[] a = Arrays.stream(scanner.next().split("[,\\[\\]]")).filter(w -> !w.equals("")).mapToInt(Integer::parseInt).toArray();

    for (int i = 0; i < a.length; i++) {
        System.out.println(a[i]);
    }