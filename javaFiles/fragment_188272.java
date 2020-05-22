if (placeholder.getText().toString().equals("BMW M4")) {

        mySound = MediaPlayer.create(this, R.raw.sound);
        mySound.start();
    }

    else if (placeholder.getText().toString().equals("BMW M5")) {

        mySound = MediaPlayer.create(this, R.raw.sound2);
        mySound.start();

    }