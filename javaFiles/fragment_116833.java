float first_x, first_y, last_x, last_y, line_lenght;
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    first_x = x;
                    first_y = y;

                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    last_x = x;
                    last_y = y;
                    line_lenght = (float) Math.pow(Math.abs(first_x-last_x),2) + (float) Math.pow(Math.abs(first_y-last_y),2);
                    line_lenght = (float) Math.sqrt(line_lenght);
                    circlePath.reset();
                    circlePath.addCircle(mX, mY, line_lenght, Path.Direction.CW);

                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:

                    last_x = x;
                    last_y = y;
                    line_lenght = (float) Math.pow(Math.abs(first_x-last_x),2) + (float) Math.pow(Math.abs(first_y-last_y),2);
                    line_lenght = (float) Math.sqrt(line_lenght);
                    circlePath.reset();
                    circlePath.addCircle(mX, mY, line_lenght, Path.Direction.CW);

                    touch_up();


                    //Mx1=(int) event.getX();
                    //My1= (int) event.getY();
                    invalidate();
                    break;
            }
            return true;
        }