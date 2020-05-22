//existing line
URL url = new URL("file:zvuk.wav" );
//new lines to debug wav file location
File myMusicFile = new File(url.getPath());
if(myMusicFile.exists() && !myMusicFile.isDirectory()) { 
    System.out.println("File exists and is not a directory");
}