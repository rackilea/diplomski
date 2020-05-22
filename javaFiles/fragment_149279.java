UtilsWithConstructor(this@MainActivity).startNewActivity(SecondActivity::class.java)

class UtilsWithConstructor(private val context: Context) {

      fun startNewActivity(clazz: Class<*>) {

    val intent = Intent(context, clazz)
    // start your next activity
    context?.startActivity(intent)

}


}