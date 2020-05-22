public void videoplay(View v){
String videopath = 
"android.resource://a0.insertvideo/"+R.raw.samplevideo_1280x720_2mb + ".mp4";  // if your video is not .mp4 change it your video extension 
Uri uri = Uri.parse(videopath); 
videov.setVideoURI(uri);
videov.start();
// a0.mcqwithvideo is my package use own package to play video right

}
}