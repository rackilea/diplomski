/** Removes the element on a given index position. It takes time linear in
   *  the buffer size.
   *
   *  @param n       the index which refers to the first element to delete.
   *  @param count   the number of elements to delete
   *  @throws Predef.IndexOutOfBoundsException if `n` is out of bounds.
   */
  override def remove(n: Int, count: Int) {
    require(count >= 0, "removing negative number of elements")
    if (n < 0 || n > size0 - count) throw new IndexOutOfBoundsException(n.toString)
    copy(n + count, n, size0 - (n + count))
    reduceToSize(size0 - count)
  }