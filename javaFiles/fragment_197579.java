View rootView = inflater.inflate(fragment_listen, container, false);

VideoView videoView = VideoView.findViewById(R.id.videoView);
videoView.setVideoPath("http://edge.mixlr.com/channel/wtrpf");
videoView.start();


return inflater.inflate(fragment_listen, null);