Try this:


        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            toggleSound= MediaPlayer.create(this, R.raw.z);
            SharedPreferences sharedPreferences = getSharedPreferences("NAME", Context.MODE_PRIVATE);
            Boolean c = sharedPreferences.getBoolean("clicked");
            if(c){
                aButton.setImageResource(R.drawable.on);
            }
            else {
                aButton.setImageResource(R.drawable.off);
            }        
        }


        public void buttonClick(View v) {
            switch (choose){
                case 1:ImageButton aButton = (ImageButton) v;
                    aButton.setImageResource(R.drawable.on);
                    toggleSound.start();
                    choose++;
                    SharedPreferences sharedPreferences = getSharedPreferences("NAME", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("clicked", true);
                    editor.commit();
                    break;
                case 2:ImageButton bButton = (ImageButton) v;
                    bButton.setImageResource(R.drawable.off);
SharedPreferences sharedPreferences = getSharedPreferences("NAME", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("clicked", false);
                    editor.commit();
                    toggleSound.start();
                    choose--;
                    break;
            }