loginBtn = (LoginButton) findViewById(R.id.fb_login_button);
            loginBtn.setUserInfoChangedCallback(new UserInfoChangedCallback() {
                @Override
                public void onUserInfoFetched(GraphUser user) {
                    if (user != null) {
                        userName.setText("Hello, " + user.getName());
                    } else {
                        userName.setText("You are not logged");
                    }
                }
            });