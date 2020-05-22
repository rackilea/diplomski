getWindow().getDecorView().setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View arg0, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_UP){
                // i have been touched
                istouched = true;
                Toast.makeText(getBaseContext(), "you touched me?!! - i will tell my mom", Toast.LENGTH_SHORT).show();
                return true;
            }
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                // you can implement this
                Toast.makeText(getBaseContext(), "shhh; i am touching", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    });