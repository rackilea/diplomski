View rootView = inflater.inflate(fragment_listen, container, false);

VideoView videoView = rootView.findViewById(R.id.videoView);
videoView.setVideoPath("http://edge.mixlr.com/channel/wtrpf");
videoView.start();

return rootView;