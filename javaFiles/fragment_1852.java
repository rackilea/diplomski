Handler handler = new Handler();
And inside onDraw method


    handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Draw the previous paths.
                    // Adjust the paths here and draw it
                    invalidate();
                }
            }, 5 * 1000);