IdentityManager.getDefaultIdentityManager().addSignInStateChangeListener(new SignInStateChangeListener() {
                @Override
                public void onUserSignedIn() {
                    Log.d(LOG_TAG, "User Signed In");
                }

                @Override
                public void onUserSignedOut() {
                    Log.d(LOG_TAG, "User Signed Out");
                }
});