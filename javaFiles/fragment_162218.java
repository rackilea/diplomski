/**
 * Test if a RecyclerView contain the right amount of elements
 */
fun withListSize(size: Int): Matcher<View> {
    return object : TypeSafeMatcher<View>() {
        var listSize = 0
        public override fun matchesSafely(view: View): Boolean {
            if ((view !is RecyclerView)) throw IllegalStateException("You cannot assert withListSize in none RecyclerView View")
            listSize = view.adapter.itemCount
            return listSize == size
        }

        override fun describeTo(description: Description) {
            description.appendText("ListView should have $size items and currently $listSize items")
        }
    }
}