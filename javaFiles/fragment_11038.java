@Override
        public void onBackPressed() {
            super.onBackPressed();
            if (LoginActivity.mLogin_activity!=null) {
                LoginActivity.mLogin_activity.finish();
                MainActivity.this.finish();
            }else {
                MainActivity.this.finish();
            }
        }