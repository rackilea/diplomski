button1.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                float x = (float) 1.25;
                float y = (float) 1.25;

                button1.setScaleX(x);
                button1.setScaleY(y);
                button1.setBackgroundResource(R.drawable.blue_220);
            }

            else if(event.getAction() == MotionEvent.ACTION_UP)
            {
                float x = 1;
                float y = 1;

                button1.setScaleX(x);
                button1.setScaleY(y);
                button1.setBackgroundResource(R.drawable.blue_206);

            }
            return false;
        }
    });