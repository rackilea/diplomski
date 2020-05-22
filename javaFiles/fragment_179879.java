TreeSet<Book> set = new TreeSet<Book>(new Comparator<Book>() {
  public int compare(Book o1, Book o2) {
    int r = o1.author.compareTo(o2.author);
    if (r != 0)
      return r;
    return o1.title.compareTo(o2.title);
  }      
});

set.add(...);