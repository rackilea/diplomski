@Suppress("ObjectLiteralToLambda")
class MainActivity : Activity() {

    // private val randomFactListener = OnClickListener {
    //    // code block
    // }

    private val randomFactListener = object : OnClickListener {

        override fun onClick(v: View?) {
            // code block
        }
    }

    // private val backToHomeListener = OnClickListener {
    //    // code block
    // }

    private val backToHomeListener = object : OnClickListener {

        override fun onClick(v: View?) {
            // code block
        }
    }

    // private val anotherRandomFactListener = OnClickListener {
    //    // code block
    // }

    private val anotherRandomFactListener = object : OnClickListener {

        override fun onClick(v: View?) {
            // code block
        }
    }

}