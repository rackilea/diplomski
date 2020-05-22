trait Equility[T] {
  def equal(t1: T, t2: T): Boolean
  def hash(t: T): Int
}

class MapWithEquility[K, V](e: Equility[K]) extends scala.collection.mutable.HashMap[K, V] {
  override def elemHashCode(key: K) = e.hash(key)
  override def elemEquals(key1: K, key2: K) = e.equal(key1, key2)
}