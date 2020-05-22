mBtnFbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                // Make your logout procedure
                ...
                otherButton.setVisibility(View.GONE);
            }
        });