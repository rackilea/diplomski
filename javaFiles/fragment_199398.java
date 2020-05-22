//initialising the two new buttons
    final Button btSong1 = (Button)findViewById(R.id.btnPlaySong1);
    final Button btSong2 = (Button)findViewById(R.id.btnPlaySong2);

    //initialising the two new media player instances
    song1 = new MediaPlayer();
    song1 = MediaPlayer.create(this, R.raw.song3);

    song2 = new MediaPlayer();
    song2 = MediaPlayer.create(this, R.raw.song4);



    //The code for the two buttons go here

    btSong1.setOnClickListener(new OnClickListener(){
        public void onClick(View v){
        //This is where your code will go
            switch(stateOfPlaying){
            case 0: 
                song1.start();
                stateOfPlaying = 1;
                btSong1.setText("Pause Song 1");
                btSong2.setVisibility(View.INVISIBLE);


                break;
            case 1:
                song1.pause();
                stateOfPlaying = 0;
                btSong1.setText("Play Song 1");
                btSong2.setVisibility(View.VISIBLE);
                break;
            }//switch

        }//end of onClick
    });//btSong1

    btSong2.setOnClickListener(new OnClickListener(){
        public void onClick(View v){
        //This is where your code will go
            switch(stateOfPlaying){
            case 0: 
                song2.start();
                stateOfPlaying = 1;
                btSong2.setText("Pause Song 2");
                btSong1.setVisibility(View.INVISIBLE);



                break;
            case 1:
                song2.pause();
                stateOfPlaying = 0;
                btSong2.setText("Play Song 2");
                btSong1.setVisibility(View.VISIBLE);
                break;
            }//switch   

        }//end of onClick
    });//btSong2