enum DisplayCharComparator implements Comparator<CreateShape> {
    INSTANCE;

    @Override
    public int compare(CreateShape s1, CreateShape s2) {
        return Character.compare(s1.getDisplayChar(), s2.getDisplayChar());
    }
}