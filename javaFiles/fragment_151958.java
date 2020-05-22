class CreateShape {

    static final Comparator<CreateShape> DISPLAY_CHAR_COMPARATOR =
        new DisplayCharComparator();

    static class DisplayCharComparator implements Comparator<CreateShape> { ... }

    // rest of the code
}