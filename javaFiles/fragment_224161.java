import scala.collection.mutable

class EquivalenceLock[A] {
  private[this] val keys = mutable.Map.empty[A, AnyRef]

  def apply[B](key: A)(f: => B): B = {
    val lock = keys.synchronized(keys.getOrElseUpdate(key, new Object()))
    lock.synchronized(f)
  }
}