TextView tv = (TextView) findViewById(R.id.iv_testing_testani);

tv.setOnClickListener(new OnClickListener() {
    public void onClick(final View v) {

        // Pass our animation drawable to our custom drawable class
        CustomAnimationDrawableNew cad = new CustomAnimationDrawableNew(
                (AnimationDrawable) getResources().getDrawable(
                        R.drawable.anim_test)) {
            @Override
            void onAnimationStart() {
                // Animation has started...
            }

            @Override
            void onAnimationFinish() {
                // Animation has finished...
            }
        };

        // Set the views drawable to our custom drawable
        v.setBackgroundDrawable(cad);

        // Start the animation
        cad.start();
    }
});