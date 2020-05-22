val autoDemoListener = View.OnClickListener {
        Is_AutoDemo_B = true
        Out("AutoDemoListener")
        switchView(demoView, registrationView)
        startRegistration()
        CoroutineScope(Job() + Dispatchers.Main).launch {
            registrationView.symbolButton[2][8].performClick()
            delay(1000)
            registrationView.symbolButton[4][13].performClick()
            delay(2000)
            registrationView.symbolButton[0][1].performClick()
            delay(1000)
            registrationView.symbolButton[6][18].performClick()
            Is_AutoDemo_B=false
        }
    }