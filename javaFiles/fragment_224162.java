/**
  * An util that provides synchronization using value equality rather than referential equality
  * It is guaranteed that if two objects are value-equal, their corresponding blocks are invoked mutually exclusively.
  * But the converse may not be true i.e. if two objects are not value-equal, they may be invoked exclusively too
  *
  * @param n There is a 1/(2^n) probability that two invocations that could be invoked concurrently is not invoked concurrently
  *
  * Example usage:
  *   private[this] val lock = new EquivalenceLock()
  *   def run(person: Person) = lock(person) { .... }
  */
class EquivalenceLock(n: Int) {
  val size = 1<<n
  private[this] val locks = IndexedSeq.fill(size)(new Object())

  def apply[A](lock: Any) = locks(lock.hashCode().abs & (size - 1)).synchronized[A] _   // synchronize on the (lock.hashCode % locks.length)th object
}

object EquivalenceLock {
  val defaultInstance = new EquivalenceLock(10)
}