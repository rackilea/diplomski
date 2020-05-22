private val delayFun: String.(Boolean) -> Unit = lifecycleScope.debounce(START_DELAY) {
        if(it){
            print(this)
        }
    }

     //call function
     "Hello world!".delayFun(true)