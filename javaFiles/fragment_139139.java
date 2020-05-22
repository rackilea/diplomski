(entry: Entry[String,Point]) => {
  def foo(entry: Entry[String,Point]) = {
    val p = entry.geometry
    val position = Position.create(p.y, p.x)
    from.getDistanceToKm(position) < distanceKm
  }

  foo(entry)
})