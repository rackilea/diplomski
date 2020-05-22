public void onClick(View v) {

        if(orangeFruit == 0) {
            orangeFruit = 1; //set orangeFruit to 1
            mySound.start(); //play sound 1     
        } else if (orangeFruit == 1) {
            orangeFruit = 0; //set orangeFruit back to 0
            mySoundb.start(); //play sound 2
        }
}