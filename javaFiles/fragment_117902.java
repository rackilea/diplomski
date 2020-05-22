val digits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

  def concat[T](it1: Iterator[T], it2: => Iterator[T]): Iterator[T] = new Iterator[T] {
    def hasNext: Boolean = it1.hasNext || it2.hasNext

    def next(): T = if (it1.hasNext) {
      it1.next()
    } else {
      it2.next()
    }
  }

  def combinationWithoutRepetitions[T](k: Int, seq: Seq[T]): Iterator[Seq[T]] = {
    def combination(k: Int, acc: Seq[T], tail: Seq[T]): Iterator[Seq[T]] = k match {
      case 0 =>
        Iterator.empty
      case 1 =>
        tail.iterator.map { t => t +: acc }
      case _ if tail.nonEmpty =>
        val it1 = combination(k - 1, tail.head +: acc, tail.tail)
        lazy val it2 = combination(k, Seq.empty, tail.tail)
        concat(it1, it2)
      case _ =>
        Iterator.empty
    }

    combination(k, Seq.empty, seq)
  }

  //TEST
  val iterator = combinationWithoutRepetitions(10, digits.toSeq) // it should return immediatelly
  println(s"${iterator.next()}")
  println(s"${iterator.next()}")

  combinationWithoutRepetitions(2, digits.toSeq).foreach{
         el => println(s"$el")
  }