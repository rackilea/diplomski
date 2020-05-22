class MainActivity : AppCompatActivity() {

    private val prefs by lazy { getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE) }

    private var customTheme: Int
        get() = prefs.getInt("theme", R.style.AppTheme_A)
        set(value) = prefs.edit()
                .putInt("theme", value)
                .apply()
                .also { recreate() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(customTheme)
        setContentView(R.layout.activity_main)

        buttonA.setOnClickListener { customTheme = R.style.AppTheme_A }
        buttonB.setOnClickListener { customTheme = R.style.AppTheme_B }
    }
}