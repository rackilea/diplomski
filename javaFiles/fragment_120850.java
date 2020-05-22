import com.google.common.collect.ImmutableList

fun main(args: Array<String>) {
  val list: List<Int> = ImmutableList.of(1, 2, 3)

  val copy = list.toMutableList()
  copy.add(4)

  println(copy) // [1, 2, 3, 4]
  println(list) // [1, 2, 3]
}