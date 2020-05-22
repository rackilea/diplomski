object TryAll {
  def apply[K](f: => K): Try[K] =
    try { 
       Success(f)
    } catch {
      case e: Throwable => Failure(e)
    }
}


TryAll {
  Calculator.eval(..)
}