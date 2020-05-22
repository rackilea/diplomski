img.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if(event.getAction() == MotionEvent.ACTION_DOWN) {

                x = event.getX();
                y = event.getY();

            } else if (event.getAction() == MotionEvent.ACTION_UP) {

                x2 = event.getX();
                y2 = event.getY();

                if(x==x2 && y==y2){



                }else{



                }

            }

            return false;
        }
    });