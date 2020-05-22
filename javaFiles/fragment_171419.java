@Override
protected void onCreate(Bundle savedInstanceState) {
    RelativeLayout myLayout = new RelativeLayout(this);

    super.onCreate(savedInstanceState);
    setContentView(myLayout);
    // Your loop would go here...
    RatingBar ratingBar = (RatingBar) getLayoutInflater()
        .inflate(R.layout.rating_bar, myLayout, false);
    myLayout.addView(ratingBar);
    ratingBar.setNumStars(5);
    ratingBar.setStepSize(0.5f);
    ratingBar.setRating(2.0f);
}