@Override public boolean equals(Object obj) {
  return Optional.ofNullable(obj)
                 .filter(that -> that instanceof Test)
                 .map(that -> (Test)that)
                 .filter(that -> Objects.equals(this.s1, that.s1))
                 .filter(that -> Objects.equals(this.s2, that.s2))
                 .isPresent();
}