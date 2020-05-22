public boolean equals(Object a) {
  if (! (a instanceof Author))
    return false;

  return this.getname().equals(((Author) a).getname());
}