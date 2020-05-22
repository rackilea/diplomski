public void add(List<B> bList) {
    for (B b : bList) {
        if (b instanceof BC) {
            bcArrayList.add((BC)b);
        }
        if (b instanceof BD) {
            bdArrayList.add((BD)b);
        }
    }         
}