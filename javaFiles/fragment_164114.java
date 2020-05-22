override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(...)
    .
    .
    .
    val subject2 = intent.getStringExtra("subject")
    val grade2 = intent.getStringExtra("grade")
    .
    .
    var words = ArrayList<Word>()

    words.add(Word(subject2, grade2))
}