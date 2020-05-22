/** There are two Singers ... no more and no less */
    public enum Singer {
        DUANE("This is my song"),
        RUPERT("I am a singing bear");

        private String song;

        Singer(String song) {
            this.song = song;
        }

        public String getSong() {
            return song;
        }
    }