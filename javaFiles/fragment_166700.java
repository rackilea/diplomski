public void doExitApp(){
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                } else {
                    finish();
                }
            }