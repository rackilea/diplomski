class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val s: String = intent.getStringExtra("Key")
        println(s)

        val textView = findViewById<TextView>(R.id.receive).apply {
            text = s
        }
    }
}