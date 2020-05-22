imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        startScaleAnimation(imageView);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        cancelScaleAnimation(imageView);
                        isMove =true;
                        break;

                    case MotionEvent.ACTION_UP:
                        cancelScaleAnimation(imageView);

                        if (!isMove){
                            isMove = false;
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    startActivity(new Intent(ActivityOne.this, ActivityTwo.class));

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                        overridePendingTransition(R.anim.enter_slide_left, R.anim.exit_slide_left);
                                    }

                                }
                            },150);
                        }else {
                            isMove = false;
                        }

                        break;
                }
                return true;
            }
        });