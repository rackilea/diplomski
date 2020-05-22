private class ByNameThenArbitrary implements Comparator<EmailTemplate> {
    @Override
    public int compare(EmailTemplate e1, EmailTemplate e2) {
        return ComparisonChain.start()
                              .compare(e1.getName(), e2.getName(), Ordering.natural().nullsFirst(),
                              .compare(e1, e2, Ordering.arbitrary())
                              .result();
    }
}