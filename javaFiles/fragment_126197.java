@annotation.tailrec
def retry[T](n: Int)(fn: => T): T = {
  val r = try { Some(fn) } catch { case e: Exception if n > 1 => None }
  r match {
    case Some(x) => x
    case None => retry(n - 1)(fn)
  }
}