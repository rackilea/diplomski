import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    print("Please enter a number range: ")
    val numOfCols = input.nextInt()

    print("Please enter a number of rows: ")
    val numOfRows = input.nextInt()

    for (i in 1..numOfRows) {
        for (j in 1..numOfCols){
            for (k in 1..numOfCols){
                if (k == i) {
                    print(k+j-1)
                } else {
                    print(1)
                }
            }
            print(" ")
        }
        println("")
    }
}