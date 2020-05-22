private val unique = buildUnique().intern

def equals(thatObj: Any) = thatObj match {
    case that : MyType => unique.eq(that.unique) // In Java: unique == that.unique
    case _             => false
  }