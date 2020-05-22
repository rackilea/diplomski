File filestring = new File("my/file/dir/file.mp3");
    Media file = new Media(filestring.toURI().toString());  

    MediaPlayer mediaPlayer = new MediaPlayer(file);

    mediaPlayer.setOnReady(new Runnable() {

        @Override
        public void run() {

            System.out.println("Duration: "+file.getDuration().toSeconds());

            // display media's metadata
            for (Map.Entry<String, Object> entry : file.getMetadata().entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // play if you want
            mediaPlayer.play();
        }
    });