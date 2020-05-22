ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 9, 10}));

    int head = list.get(0);
    int tail = list.get(list.size() - 1);

    int length = tail - head + 1;
    int[] array = new int[length];

    for (int i : list) {
        array[i - head] = 1;
    }

    for (int i = 0; i < array.length; i++) {
        if (array[i] == 0) {
            System.out.println(String.format("Missing %d, position %d", i + head, i + 1));
        }
    }