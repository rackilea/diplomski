class DataFetcher(val repo: Repository) {
  fun fetchData1() {
    // implementation
  }

  fun fetchData2() {
    // implementation
  }
}

class MyFragment : Fragment, MyListener {
  val dataFetcher = DataFetcher(Repository())

  fun myFun1() = dataFetcher.fetchData1()

  fun myFun2() = dataFetcher.fetchData2()

  fun myFun23() {}
}

class MyActivity : AppCompatActivity, MyListener {
  val dataFetcher = DataFetcher(Repository())

  fun myFun1() = dataFetcher.fetchData1()

  fun myFun2() = dataFetcher.fetchData2()

  fun myFun34() {}
}