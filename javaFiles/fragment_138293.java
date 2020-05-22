//create an array to store the duration of each file.
int[] durations = new int[10];

//create a MediaPlayer
MediaPlayer mp =  new MediaPlayer();
for(int i = 0;i<durations.length;i++);
    try {
        //for each file, load it into MediaPlayer, get the file's duration, and then reset the MediaPlayer
        mp.setDataSource("file"+i+".ogg");
        mp.prepare();
        durations[i] = mp.getDuration();
        mp.reset();
        }
    catch(IOException ioe) {}
 }