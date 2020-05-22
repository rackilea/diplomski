Comparator<XNode> comp = new Comparator<XNode>() {
    @Override
    public int compare(XNode o1, XNode o2) {
        return Long.valueOf(o1.magicNumber).compareTo(o2.magicNumber);
    }
};
SortedSet<XNode> set = new TreeSet<>(comp);