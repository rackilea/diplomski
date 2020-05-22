QBUsers.signUp(user, new QBEntityCallbackImpl<QBUser>() {
        public void onSuccess(QBUser result, Bundle params) {
            // success
        }

        public void onError(List<String> errors) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(
                    SplashActivity.this);
            dialog.setMessage(
                    "register errors: " + errors)
                    .create().show();
        }
    });