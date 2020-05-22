RunnableAction playWooshAction = Actions.run(new Runnable() {
        @Override
        public void run() {
            com.pentagames.flappybibi.Assets.playWooshSound();
             game.adService.showInterstitial();
        }
});