int maxColSize = outer.stream().mapToInt(List::size).max().orElse(0);
for (int y=0; y<maxColSize; y++) {
    for (int x=0; x<outer.size(); x++) {
        List<Integer> currentInner = outer.get(x);
        if (currentInner.size() > y) {
            System.out.println(currentInner.get(y));
        }
    }
}