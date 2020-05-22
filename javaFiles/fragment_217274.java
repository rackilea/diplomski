@tailrec
def expand_neighbors_impl(ghCenter: GeoHash, toGoThrough: List[GeoHash], buffer: Set[GeoHash] = Set()): Set[GeoHash] = {
  toGoThrough.headOption match {
    case None => buffer
    case Some(ghCur) =>
      if (buffer contains ghCur) {
        expand_neighbors_impl(ghCenter, toGoThrough.tail, buffer)
      }
      else {
        val neighbors = get4GeoHashAround(ghCur).filter(distanceBetweenGeohash(ghCenter, _) <= radius)
        expand_neighbors_impl(ghCenter, neighbors ++: toGoThrough, buffer + ghCur)
      }
  }
}

def expand_neighbors_impl(ghCenter: GeoHash, ghCur: GeoHash): Set[GeoHash] =
  expand_neighbors_impl(ghCenter, List(ghCur))