class DataFetchingStrategy(val repo: Repository) : MyListener {
    fun myFun1() {
      repo.fetchData1()
    }

    fun myFun2() {
      repo.fetchData2()
    }
}