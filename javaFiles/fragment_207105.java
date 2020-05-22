fun main(args: Array<String>) {
    val texts = listOf("It is a",
            "long established fact that a reader will be distracted,",
            "by the readable content of a page when looking at its layout.",
            "The point of using Lorem Ipsum is that it has a more-or-less normal",
            "distribution of letters, as opposed to using, making it look like readable English.",
            " Many desktop publishing packages and web page,",
            "editors now use Lorem Ipsum as their default model text, and a search,",
            "for \'lorem ipsum\' will uncover many web sites still in their infancy",
            "Various versions have evolved over the years")

    val limit = 130
    var sum = 0
    val str = texts.takeWhile { sum += it.length + 1;  sum <= limit }.joinToString(" ")

    println(str)
    println(str.length)
}