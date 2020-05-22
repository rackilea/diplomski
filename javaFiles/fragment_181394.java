public void enq(Object x) {
    Entry help = new Entry();
    help.content = x;
    **tail = help;**

    if (head == null) {
      head = help;
    }

    help.next = null;
  }