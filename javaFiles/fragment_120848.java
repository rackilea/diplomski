fun main(args: Array<String>) {
  // Explanation for ArrayList(listOf()) later down the post
  val list: List<Int> = ArrayList(listOf(1, 2, 3))
  println(list) // [1, 2, 3]

  // Fails at compile time
  // list.add(4)

  // Uh oh! This works at runtime!
  (list as MutableList<Int>).add(4)
  println(list) // [1, 2, 3, 4]
}