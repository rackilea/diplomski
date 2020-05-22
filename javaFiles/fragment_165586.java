@SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                        // Update UI to reflect text being shared
                        if (it == "press_button2"){
                            myButton.performClick()
                        }
                    }
                }
            }

        }
    }