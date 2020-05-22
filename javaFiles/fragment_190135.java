// You can't do this
buttonPlay.addListener(new ClickListener(){                   // 1
    public void clicked(InputEvent event, float x, float y) { // 2
        public GameScreen(Create create) {                    // 3
            this.create = create;                             // 3
        }                                                     // 3
    }
});