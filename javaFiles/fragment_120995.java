// Callback handler for the sign-in process 
AuthenticationHandler authenticationHandler = new AuthenticationHandler() { 

    @Override
    public void onSuccess(CognitoUserSession cognitoUserSession) { 
        // Sign-in was successful, cognitoUserSession will contain tokens for the user   
    }

    @Override
    public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String userId) { 
        // The API needs user sign-in credentials to continue
        AuthenticationDetails authenticationDetails = new AuthenticationDetails(userId, password, null);

        // Pass the user sign-in credentials to the continuation
        authenticationContinuation.setAuthenticationDetails(authenticationDetails);

        // Allow the sign-in to continue
        authenticationContinuation.continueTask();
    }

    @Override
    public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) { 
        // Multi-factor authentication is required; get the verification code from user
        multiFactorAuthenticationContinuation.setMfaCode(mfaVerificationCode);
        // Allow the sign-in process to continue
        multiFactorAuthenticationContinuation.continueTask();
    }

    @Override
    public void onFailure(Exception exception) {
        // Sign-in failed, check exception for the cause
    } 
};

// Sign in the user 
cognitoUser.getSessionInBackground(authenticationHandler);