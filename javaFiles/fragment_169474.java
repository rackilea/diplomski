class HashView : View("My View") {
    val inputProperty = SimpleStringProperty()
    val hashProperty = inputProperty.stringBinding { computeHash(it ?: "EMPTY") }

    override val root = vbox {
        textfield(inputProperty)
        label(hashProperty)
    }

    fun computeHash(t: String) = "Computed: $t"
}