private OnTouchListener onTouchListener = new OnTouchListener() {

        private boolean flag = false;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (v.getId() == R.id.button) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    flag = true;
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            while(flag) {
                                //do something
                            }
                        }
                    });
                    thread.start();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    flag = false;
                }
            } 
            return true;
        }
    }