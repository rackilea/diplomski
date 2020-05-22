VideoView videoView = (VideoView)findViewById(R.id.myVideo);
String vidAddress = "https://ia800201.us.archive.org/22/items/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
videoView.setVideoURI(Uri.parse(vidAddress));
videoView.setZOrderOnTop(true);//add this line 
MediaController vidControl = new MediaController(this);
vidControl.setAnchorView(videoView);
videoView.setMediaController(vidControl);
videoView.start();