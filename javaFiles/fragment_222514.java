Arrays.stream(txt).forEach(row -> {
    Arrays.stream(row).forEach(element -> {
        System.out.print(element);
        System.out.print("\t");
    });
    System.out.println();
});