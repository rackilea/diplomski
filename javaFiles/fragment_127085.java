while (monitor.getSize() > 1) {
    System.out.println("Number of array in list to be sorted: "
            + monitor.getSize());

    String[] f = monitor.getRandom();
    String[] g = monitor.getRandom();

    monitor.add(descSort(f, g));
}