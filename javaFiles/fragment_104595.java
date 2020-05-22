import java.util.*

fun main(args: Array<String>) {
    val input = "CT >RUSSO CT >JOSE AQUINO CP >RENATO DE SA CP >FRAIS ...";
    val split = input.split("( (?=[A-Z]{2} >)| >)".toRegex())
    for (i in split.indices step 2) 
       println(split[i] + ", " + split[i + 1])
}