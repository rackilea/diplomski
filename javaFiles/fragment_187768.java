public boolean add(List<? extends JLabel> j) {
    boolean t = true;
    for (JLabel b : j) {
        if (b instanceof JLabel) {
            t = t && labels.add(b);
        }
    }
    return t;
}