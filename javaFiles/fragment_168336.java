public static Predicate<Bid> isBidByUser(final User usr) {
    return new Predicate<Bid>() {
      @Override public boolean apply(Bid p) {
        return p.getUser().getName().equals(usr.getName());
      }
    };
}