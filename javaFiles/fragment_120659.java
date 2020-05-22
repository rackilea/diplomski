fab.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                // previously invisible view
                View myView = findViewById(R.id.revealview);

// get the center for the clipping circle
                int cx = myView.getWidth() / 2;
                int cy = myView.getHeight() / 2;

// get the final radius for the clipping circle
                int finalRadius = Math.max(myView.getWidth(), myView.getHeight());

// create the animator for this view (the start radius is zero)
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);

                //Interpolator for giving effect to animation
                anim.setInterpolator(new AccelerateDecelerateInterpolator());
                // Duration of the animation
                anim.setDuration(1000);

// make the view visible and start the animation
                myView.setVisibility(View.VISIBLE);
                anim.start();
            }
        });
    }