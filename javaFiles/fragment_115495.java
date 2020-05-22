List<String> listAll = Arrays.asList("1","1","2","3","4","4","4","5","6","6","7","8","9","9");

for (String item : listAll) {
    if (Collections.frequency(listAll, item) == 1) {
        System.out.println(item);
    }
}