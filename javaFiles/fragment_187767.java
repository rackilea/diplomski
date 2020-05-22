public <E extends JLabel> boolean add(List<E> j) {
    boolean t = true;
    for (JLabel b : j) {
        if (b instanceof JLabel) {
            t = t && labels.add(b);
        }
    }
    return t;
}