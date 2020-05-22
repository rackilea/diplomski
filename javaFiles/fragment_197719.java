class Person {
    val nameProperty = SimpleStringProperty()
    var name by nameProperty

    val favoriteFruitProperty = SimpleStringProperty()
    var favoriteFruit by favoriteFruitProperty
}

class MyView : View() {
    val fruits = listOf("Apple", "Banana", "Pear")

    override val root = tableview<Person> {
        isEditable = true

        column("Name", Person::nameProperty)
        column<Person, String?>("Favorite fruit", Person::favoriteFruitProperty).useComboBox(fruits.observable())

        // Populate with test data. Don't try this at home
        asyncItems {
            listOf(Person().apply { name = "John"; favoriteFruit = "Apple" }, Person().apply { name = "Jane" })
        }
    }
}