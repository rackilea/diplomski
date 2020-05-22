@Test
fun testFilter() {

    // Properties of a product
    data class Properties(val city: String, val day: Int, val month: Int, val yearProp: Int, val dayEnd: Int, val monthEnd: Int, val yearEndProp: Int, val priceFrom: Int, val priceTo: Int)

    // A product (notice it references Properties)
    data class Product(val productProperties: Properties, val title: String, val price: String, val photoId : String)

    // Let's pretend these came from the server (we parsed them using Gson converter)
    val productA = Product(Properties("New York", 0, 0, 0, 0, 0, 0, 0, 0), "Sweets", "$1", "1")
    val productB = Product(Properties("Boston", 0, 0, 0, 0, 0, 0, 0, 0), "Eggs", "$2", "1")
    val productC = Product(Properties("New York", 0, 0, 0, 0, 0, 0, 0, 0), "Flour", "$1", "1")

    // Create a list of the products
    val listOfProducts = mutableListOf(productA, productB, productC)

    // Filter the products which have new york as the city in their properties
    val filteredNewYorkProducts = listOfProducts.filter { it.productProperties.city == "New York" }

    // Assert that the filtered products contains 2 elements
    Assert.assertTrue(filteredNewYorkProducts.size == 2)

    // Assert that the filtered products contains both product A and B
    Assert.assertTrue(filteredNewYorkProducts.contains(productA))
    Assert.assertTrue(filteredNewYorkProducts.contains(productB))
}