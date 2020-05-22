import scala.io.Source

object Hash extends App {
    val size = 216555
    def doubleHashKey1(word: String) = {
        var jump = 1;
        for (ch <- word) {
            jump = jump * ch;
            jump = jump % size;
        }
        jump
    }

    def doubleHashKey2(word: String) = {
        var jump = 1;
        for (ch <- word) jump = jump * ch;
        jump % size;
    }

    def countCollisions(words: Set[String], hashFun: String => Int) = words.size - words.map(hashFun).size
    def readDictionary(path: String) = Source.fromFile(path).getLines.toSet

    val dict = readDictionary("words.txt")
    println(countCollisions(dict,doubleHashKey1))
    println(countCollisions(dict,doubleHashKey2))
}