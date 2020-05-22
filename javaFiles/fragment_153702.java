int number; // = some int

List<Integer> arrList = new ArrayList<>();

while (number > 0) {
    // To keep the same order, use arrList.add(0, number % 10);
    arrList.add(number % 10);
    number = number / 10;
}

Integer[] arr = new Integer[arrList.size()];
arrList.toArray(arr);