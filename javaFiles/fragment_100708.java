mDrawView.setOnDrawViewListener(new DrawView.OnDrawViewListener() {
                @Override public void onStartDrawing() {
                    canUndoRedo();
                    // decide whether or not to show an
                    // indicator and style it depending on
                    // mDrawView's attributes and current drawing mode

                    setIndicator(mDrawView.getDrawingMode(),mDrawView.getDrawWidth());
                }

                @Override
                public void onMove(MotionEvent motionEvent) {
                    if(isIndicatorVisible){
                        indicatorView.animate()
                                .x(motionEvent.getX())
                                .y(motionEvent.getY())
                                .setDuration(0)
                                .start();
                    }

                }

                @Override public void onEndDrawing() {
                    canUndoRedo();
                    //hide indicator here
                    if (isIndicatorVisible){
                        indicatorView.setVisibility(View.GONE);
                        isIndicatorVisible = false;

                    }

                }