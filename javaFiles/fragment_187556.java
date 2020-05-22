async{
    val tenny = async { star_ten(1) } //Should be Deferred<Int>
    val twy = async { star_two(10)}   //Should be Deferred<Int>
    println(twy.await() + tenny.await())
}

suspend fun star_two(num:Int): Int = num * 2
suspend fun star_ten(num:Int): Int = num * 10