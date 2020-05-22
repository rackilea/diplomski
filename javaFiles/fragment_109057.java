class MyActivity : AppCompatActivity() {
  private lateinit var mViewModel: MyVM
  ...
  override fun onCreate(outState: Bundle?) {
    //initialize your view model here...
    mViewModel.fetchSpinnerItems().observe(this, Observer { spinnerData ->
      val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerData)
      mSpinner.adapter = spinnerAdapter
    })
  ...
}