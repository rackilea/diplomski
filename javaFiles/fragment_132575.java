val fib: Int => Int = {
    val m = ArrayBuffer(0, 1)

    x => if (x < m.size) m(x) else {
      println("Calculating " + x + "...")
      val r = fib(x - 2) + fib(x - 1)
      m += r
      r
    }
  }