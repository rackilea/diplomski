import com.google.common.collect.ImmutableList

fun main(args: Array<String>) {
  val list: List<Int> = ImmutableList.of(1, 2, 3)
  println(list) // [1, 2, 3]

  // Fails at compile time
  // list.add(4)

  // Fails at runtime, as expected
  (list as MutableList<Int>).add(4)
  println(list) // [1, 2, 3, 4]
}