Utils.startNewActivity(view.context,SecondActivity::class.java)









    class Utils {

        companion object {
            fun startActivity(context: Context, clazz: Class<*>) {

                val intent = Intent(context, clazz)

               // start your next activity

                context.startActivity(intent)

            }
        }

}