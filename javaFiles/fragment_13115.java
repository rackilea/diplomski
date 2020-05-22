void doAnimation() {
    ImageView logo = findViewById(R.id.logo);

    // new Runnable() can be substituted with () -> if you are using Java 8
    logo.post(new Runnable() { 
        @Override
        public void run() {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float density = getResources().getDisplayMetrics().density;

            // Finds the scale needed to make the logo as tall as the actionBar
            float scaleVal = 56 / (logo.getHeight() / density);

            // Gets the width and height in dp
            float width = displayMetrics.widthPixels / density;
            float height = displayMetrics.heightPixels;

            // The final X and Y in dp
            float finalX = logo.getX() + width / 2;

            logo.animate()
                    .setDuration(ANIMATION_DURATION)
                    .scaleX(scaleVal).scaleY(scaleVal)
                    .xBy(finalX).y(0);
        }
    });
}