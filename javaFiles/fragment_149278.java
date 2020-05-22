object Utils {

     fun startNewActivity(context: Context, clazz: Class<*>) {

            val intent = Intent(context, clazz)
// To pass any data to next activity
//            intent.putExtra("keyIdentifier", value)
// start your next activity
            context.startActivity(intent)

        }


}