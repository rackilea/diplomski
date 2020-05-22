for (int i = 0; i < 8; i++) numbers[i] = i;
    Arrays.sort(numbers, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.bitCount(o1)-Integer.bitCount(o2);
        }
    });
    System.out.println(Arrays.toString(numbers));