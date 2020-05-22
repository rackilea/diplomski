public final class NumberStringComparator implements Comparator<List<String>> {
    private Collator collator = Collator.getInstance();
    @Override
    public int compare(List<String> r1, List<String> r2) {
        for (int i = 0; ; i++) {
            if (i == r1.size())
                return (i == r2.size() ? 0 : -1);
            if (i == r2.size())
                return 1;
            String v1 = r1.get(i), v2 = r2.get(i);
            BigDecimal n1 = null, n2 = null;
            try { n1 = new BigDecimal(v1); } catch (@SuppressWarnings("unused") NumberFormatException unused) {/**/}
            try { n2 = new BigDecimal(v2); } catch (@SuppressWarnings("unused") NumberFormatException unused) {/**/}
            int cmp = (n1 == null ? (n2 == null ? this.collator.compare(v1, v2) : 1) : (n2 == null ? -1 : n1.compareTo(n2)));
            if (cmp != 0)
                return cmp;
        }
    }
}