val future = {
  val f1 = Future { ...; true }
  val f2 = Future { ...; 42 }
  f1.flatMap { b =>
    if(b) f2 else Future.successful(0)
  }
}