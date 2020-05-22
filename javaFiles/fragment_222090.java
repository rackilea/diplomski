boolean dragged = false;
 ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
 int minTouchSlop = viewConfiguration.getScaledTouchSlop();

 .....

 public boolean onTouch(View v, MotionEvent event)
    {
        float currX,currY;

        int action = event.getAction();
        switch (action ) {
            case MotionEvent.ACTION_DOWN:
            {
                mPrevX = event.getRawX();
                mPrevY = event.getRawY();

                btnPrevX = tweatBtn.getX();
                btnPrevY = tweatBtn.getY();

                dragged = false; // global dragged variable

                break;
            }

            case MotionEvent.ACTION_MOVE:
            {
                Display display = getActivity().getWindowManager().getDefaultDisplay();
                int width  = display.getWidth() + 80;  // deprecated
                int height = display.getHeight();  // deprecated

                currX = event.getRawX();
                currY = event.getRawY();

                if(Math.abs(currX-mPrevX) > minTouchSlop || Math.abs(currY-mPrevY) > minTouchSlop)
                     dragged = true; // differntiate btw drag or click


                if(tweatBtn.getY() > 80 && tweatBtn.getX() > 0 && tweatBtn.getX() < width)
                {
                    tweatBtn.setX(btnPrevX + currX - mPrevX);
                    tweatBtn.setY(btnPrevY + currY - mPrevY);
                }
                else
                {
                    if((btnPrevY + currY - mPrevY) > 70 && (btnPrevX + currX - mPrevX) > -10 && tweatBtn.getX() < (width - 10))
                    {
                        tweatBtn.setX(btnPrevX + currX - mPrevX);
                        tweatBtn.setY(btnPrevY + currY - mPrevY);
                    }
                }
                break;
            }

            case MotionEvent.ACTION_CANCEL:
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        return dragged;
    }