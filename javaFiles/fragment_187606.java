/** There is only one singer and he knows only one song */
    public class Singer {
        private static Singer theSinger = new Singer();
        private String song = "I'm just a singer";

        private Singer() { 
            /* to prevent instantiation */
        }

        public static Singer getSinger() { 
            return theSinger; 
        }

        public String getSong() {
            return song;
        }
    }