import java.util.Calendar
import java.text.SimpleDateFormat

data class Item(
        val month: String,
        val number: String,
        val nameDay: String
) {
    val printDay = "$nameDay $number"
}

fun main(args: Array<String>) {

    val cal: Calendar = Calendar.getInstance()

    val maxDays: Int = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    val sdfDay: SimpleDateFormat = SimpleDateFormat("dd")
    val sdfNamDay: SimpleDateFormat = SimpleDateFormat("E")
    val sdfMonth: SimpleDateFormat = SimpleDateFormat("MMM")

    val items = (0..45).map {
        val item = Item(
                sdfMonth.format(cal.time),
                sdfDay.format(cal.time),
                sdfNamDay.format(cal.time)
        )
        cal.add(Calendar.DATE, 1)
        item
    }.groupBy {
        it.month
    }.entries.fold("", { acc, item ->
        acc + item.key + ": " + item.value.map { it.printDay }.joinToString(" / ") + "\n"
    })

    println(items)
}