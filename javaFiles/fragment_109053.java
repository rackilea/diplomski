class Thread {
  @OneToMany( mappedBy = "thread" )
  List<Entry> entries;
}

class Entry {
  @ManyToOne
  Thread thread;
}