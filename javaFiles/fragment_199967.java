// Original image
// This could have been set in your layout file. 
// In this case, you can skip this statement.

imageButton. setImageDrawable(getResources().getDrawable(
             R.drawable.some_drawable_id));


someButton.setOnClickListener(new OnClickListener() {

    public void onClick(View view) {

        if (someCondition) {

            // Change image
            imageButton.setImageDrawable(getResources().getDrawable(
                R.drawable.some_drawable_that_will_stay_for_5_secs));

            // Handler
            new Handler().postDelayed(new Runnable() {

                public void run() {
                    // Revert back to original image
                    imageButton.setImageDrawable(getResources().getDrawable(
                                                R.drawable.some_drawable_id));            
                }
           }, 5000L);    // 5000 milliseconds(5 seconds) delay
        }
    }
});