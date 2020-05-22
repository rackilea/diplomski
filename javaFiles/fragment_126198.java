@annotation.tailrec
def retry[T](n: Int)(fn: => T): T = {
  try {
    return fn
  } catch {
    case e if n > 1 => // ignore
  }
  retry(n - 1)(fn)
}