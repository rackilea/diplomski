View rootView = inflater.inflate(fragment_listen, container, false);

VideoView videoView = rootView.findViewById(R.id.videoView);
videoView.setVideoPath("http://edge.mixlr.com/channel/wtrpf");

MediaController mediaController = new MediaController(this);
mediaController.setAnchorView(videoView);
videoView.setMediaController(mediaController);

videoView.start();

return rootView;