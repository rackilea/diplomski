public enum SortBy implements Comparator<Item> {
    CATEGORY {
        @Override
        public final int compare(final Item o1, final Item o2) {
            return compareStrings(o1.getCategory(), o2.getCategory());
        }
    },
    ENGLISH {
        @Override
        public final int compare(final Item o1, final Item o2) {
            return compareStrings(o1.getEnglish(), o2.getEnglish());
        }
    },
    NORWEGIAN {
        @Override
        public final int compare(final Item o1, final Item o2) {
            return compareStrings(o1.getNorwegian(), o2.getNorwegian());
        }
    };

    private static int compareStrings(final String s1, final String s2) {
        if (s1 == null) {
            return s2 == null ? 0 : -1;
        }
        if (s2 == null) {
            return 1;
        }
        return s1.compareTo(s2);
    }
}