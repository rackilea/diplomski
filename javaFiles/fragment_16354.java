boolean isPlay = false;
PlayPauseView view = (PlayPauseView) findViewById(R.id.play_pause_view);
view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlay = !isPlay;
                view.toggle();
            }
});