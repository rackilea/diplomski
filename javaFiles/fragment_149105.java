final RatingBar[] ratingBars = {
    (RatingBar) findViewById(R.id.ratingBar1),
    (RatingBar) findViewById(R.id.ratingBar2),
    (RatingBar) findViewById(R.id.ratingBar3),
    (RatingBar) findViewById(R.id.ratingBar4)
};

for (final RatingBar ratingBar : ratingBars) {
    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar bar, float rating, boolean fromUser) {
            // Implement your logic here               

            float total = 0.0f;
            for (final RatingBar ratingBar : ratingBars) {
                total += ratingBar.getRating();
            }
            float average = total / 4.0f;
            setTitle("Average: " + average);
        }
    });
}