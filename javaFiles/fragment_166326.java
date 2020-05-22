// Hooking up to the players API
    playerView.registerJsCallbackReady(new KPlayerJsCallbackReadyListener() {
        @Override


        public void jsCallbackReady() {
         // Player is loaded and we tell it to play the video
            playerView.play();





            playerView.addKPlayerEventListener("playerPaused", new KPlayerEventListener() {
                @Override
                public void onKPlayerEvent(Object body) {
                    // Player is paused, do something

                }

                @Override
                public String getCallbackName() {

                    return "onPlayerPaused";
                }

            });

            playerView.addKPlayerEventListener("playerPlayed", new KPlayerEventListener() {
                @Override
                public void onKPlayerEvent(Object body) {
                    // Player is playing, do something

                }

                @Override
                public String getCallbackName() {

                    return "onPlayerPlayed";
                }
            });



            playerView.addKPlayerEventListener("playerPlayEnd", new KPlayerEventListener() {
                @Override
                public void onKPlayerEvent(Object body) {
                   // Player have finished the video, do something

                }

                @Override
                public String getCallbackName() {

                    return "onPlayerPlayEnd";
                }
            });


        }


    });


}