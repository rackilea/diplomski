// Returning T, throwing the exception on failure
@annotation.tailrec
def retry[T](n: Int)(fn: => T): T = {
  util.Try { fn } match {
    case util.Success(x) => x
    case _ if n > 1 => retry(n - 1)(fn)
    case util.Failure(e) => throw e
  }
}

// Returning a Try[T] wrapper
@annotation.tailrec
def retry[T](n: Int)(fn: => T): util.Try[T] = {
  util.Try { fn } match {
    case util.Failure(_) if n > 1 => retry(n - 1)(fn)
    case fn => fn
  }
}