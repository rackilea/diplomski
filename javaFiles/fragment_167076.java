List<Integer> array2 = new ArrayList<>();
for (int value : array1) {
    if (approved(value)) {
        array2.add(value);
    }
}