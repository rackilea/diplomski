@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tv = (TextView) findViewById(R.id.tv);
    button = (Button) findViewById(R.id.button);

    // mSlideOutTop not used       

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            animateRemoval(v);
            in = true;

            // Do NOT set visibility to ANYTHING in here
        }
    });
}


private void animateRemoval(final View toRemove) {
    // The method .animate() creates a ViewPropertyAnimator.
    toRemove.animate()
            .setDuration(600)               // Previously defined in slide_out_top.xml
            .translationY(1000)             // Tweak this number to fit the direction/amplitude, I'm talking a wild guess
            .withEndAction(new Runnable() { // Stuff in here runs AFTER the animation.
                @Override
                public void run() {
                    // It is critical that this method be executed AFTER the animation, because it 
                    // will cause a layout to occur, and executing layouts during animation is bad news bears.
                    toRemove.setVisibility(View.GONE);
                }
            });
}