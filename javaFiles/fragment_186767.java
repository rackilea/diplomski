class MyApp: App() {
    override val primaryView = MyView::class
    companion object {
        @JvmStatic
        fun main(args: Array<String>): Unit {
            MyApp().launch(*args)
        }
    }
}