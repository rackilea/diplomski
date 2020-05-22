setContentView(R.layout.activity_main)
val view = findViewById<NavigationView>(R.id.nav_view)
view?.viewTreeObserver?.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener{
    override fun onGlobalLayout() {
        val header = findViewById<TextView>(R.id.nav_header_textView)
        header.text= "Hallo Main"
        view.viewTreeObserver.removeOnGlobalLayoutListener(this)
    }
})