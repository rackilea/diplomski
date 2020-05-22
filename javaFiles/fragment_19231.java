case c: Command =>
  val p = Promise[Event]()

  persist(Event(c)) { e => 
    p success e 
  }

  sender() ! p.future // Future[T]