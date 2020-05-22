class MyVM : ViewModel() {
  ...
  private val mSpinnerData = MutableLiveData<List<String>>()
  ...
  fun fetchSpinnerItems(): LiveData<List<String>> {
    //fetch data
    mSpinnerData.value = <some fetched list of Strings>
    return mSpinnerData
  }
}