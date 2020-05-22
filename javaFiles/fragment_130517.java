@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            CircleImageView circleImageView = (CircleImageView) findViewById(R.id.profile_image);
            Glide.with(List.this).load(user.getPhotoUrl()).into(circleImageView);
    }