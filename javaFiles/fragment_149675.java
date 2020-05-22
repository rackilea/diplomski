PhoneAuthProvider.getInstance().verifyPhoneNumber(
        phoneNumber,        
        60,                 
        TimeUnit.SECONDS,   
        this,               
        mCallbacks);