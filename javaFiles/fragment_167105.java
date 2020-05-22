String path = "path to new mono mp3 file";
File mp3File = new File(path);
FileOutputStream fos = new FileOutputStream(mp3File) ;
fos.write(byteArray);
fos.close();

mediaPlayer = MediaPlayer.create(getApplicationContext(),Uri.fromFile(mp3File));
mediaPlayer.start();