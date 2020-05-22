class MainActivity : AppCompatActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val s = tvDisplay.text.toString()

    btnOk.setOnClickListener {
        Download().execute(s)

    }
}

inner class Download : AsyncTask<String, Void, Void>() {
    override fun doInBackground(vararg ss: String?): Void? {
        validate(ss[0]!!)
        return null
    }


}

private fun validate(s:String) {

    if(s.isNotEmpty()){

        runOnUiThread {
            Toast.makeText(this, "Working :)", Toast.LENGTH_SHORT).show()
        }

    }
    else{
        runOnUiThread {
            Toast.makeText(this, "Not Working :(", Toast.LENGTH_SHORT).show()
        }
    }
}