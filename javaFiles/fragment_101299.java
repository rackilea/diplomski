data class TestStatistics(val doubleCashBack: Double, val doubleAmount: Double, val currencyId: Int)
data class TestCurrency(val currencyId: Int, val currencySign: String)
data class TestDashboardStatistics(val count: Int?, val cashBack: Double, val amount: Double, val testCurrency: TestCurrency)

object Helloworld {
    private fun getStatistics(): Observable<TestStatistics> {
        return Observable
            .fromIterable(listOf(
                TestStatistics(1.1, 1.2, 4),
                TestStatistics(2.1, 2.2, 1),
                TestStatistics(3.1, 3.2, 99),
                TestStatistics(4.1, 4.3, 2),
                TestStatistics(5.1, 5.3, 3)
            ))
            .delay(2, TimeUnit.SECONDS)
    }

    private fun getCurrencyById(id: Int): TestCurrency? {
        // blocking call
        return when (id) {
            1 -> TestCurrency(1, "!")
            2 -> TestCurrency(2, "@")
            3 -> TestCurrency(3, "#")
            else -> null
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        getStatistics()
            .map { getCurrencyById(it.currencyId) to it }
            .filter { it.first != null }
            .map { TestDashboardStatistics(null, it.second.doubleCashBack, it.second.doubleAmount, it.first!!) }
            .subscribe { println(it) }

        Thread.sleep(5000)
    }
}