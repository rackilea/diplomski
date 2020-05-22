Music songA = new Music();
Music songB = new Music();

//Start playing song A
songA.playMusic("path");

//Some stuff happens with your game...

//Some time later you want to change to song B
songA.stop();
songB.playMusic("other path");