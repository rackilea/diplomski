load("lib.js");

imgSize = 60;

setSound("bounce.wav");
rndSound(["bounce.wav", "gigi.wav"]);
rndSoundDisable(3, 1);
rndImg(1920 - imgSize * 2, 1080 - imgSize * 2, "logo.png");
addImg(0, 0, "bg.png");
rndImg(1920 - imgSize * 2, 1080 - imgSize * 2, "blub.png");

data;