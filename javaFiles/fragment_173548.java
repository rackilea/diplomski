// Injected by constructor
class MyViewModel(val repo : MyRepository) : ViewModel()

// declared ViewModel using the viewModel keyword
val myModule : Module = module {
  viewModel { MyViewModel(get()) } 
  single { MyRepository() }
}

// Just get it
class MyActivity() : AppCompatActivity() {

  // lazy inject MyViewModel
  val vm : MyViewModel by viewModel()
}