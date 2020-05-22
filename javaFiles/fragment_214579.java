............
    ...................

    TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
    Button btnStart = (Button) findViewById(R.id.btnStart);

    // load the animation
    Animation animSequestialMove = AnimationUtils.loadAnimation(getApplicationContext(),
            R.anim.sequestial_move);

    // button click event
    btnStart.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            txtMessage.setVisibility(View.VISIBLE);

            // start the animation
            txtMessage.startAnimation(animSequestialMove);
        }
    });

    .............
    .....................