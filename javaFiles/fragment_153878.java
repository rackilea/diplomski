myHandler1.post(new Runnable() { //call handler
            @Override
            public void run() {
                myLoadingText1.setVisibility(View.VISIBLE); // sets loading complete to visible after time elapsed
                visible = 1;
                startActivity(new Intent(this, login_register.class));
            }
        });