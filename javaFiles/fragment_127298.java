findViewById(R.id.customDigitsButton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            verifyMobileUsingDigits();
        }
    });

private AuthCallback authCallback;
public void verifyMobileUsingDigits(){
    logoutFabricDigits("verifyMobileUsingDigits");// manual deletion of all digit sessions, as only Digits.getSessionManager().clearActiveSession() did not helped me.....
    if(authCallback == null){
        authCallback = new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                Toast.makeText(getApplicationContext(), "Authentication successful for " + phoneNumber, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(DigitsException exception) {
                Toast.makeText(getApplicationContext(), "Authentication failure", Toast.LENGTH_LONG).show();
            }
        };
    }
    DigitsAuthConfig.Builder digitsAuthConfigBuilder = new DigitsAuthConfig.Builder()
            .withAuthCallBack(authCallback)
            .withPhoneNumber("+880")
            .withEmailCollection(false)
            .withThemeResId(R.style.CustomDigitsTheme);
    Digits.authenticate(digitsAuthConfigBuilder.build());
}

public static void logoutFabricDigits(String TAG){
    try {
        Map<Long, DigitsSession> digitsSessionMap = Digits.getSessionManager().getSessionMap();
        if(digitsSessionMap != null){
            Set<Long> digitIdSet = new HashSet<>(digitsSessionMap.keySet());
            for(Long digitId : digitIdSet){
                DigitsSession digitsSession = digitsSessionMap.get(digitId);
                if(digitsSession != null){
                    Digits.getSessionManager().clearSession(digitsSession.getId());
                }
            }
        }
        Digits.getSessionManager().clearActiveSession();
    } catch (Exception e) {
        e.printStackTrace();
    }
}