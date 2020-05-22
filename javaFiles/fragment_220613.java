public enum Numbers{
    One {
        @Override
        public String getDigit(){
            return "1";
        }
    },
    Two {
        @Override
        public String getDigit(){
            return "2";
        }
    },
    Three {
        @Override
        public String getDigit(){
            return "3";
        }
    };

    // Define the `getDigit()` method on the level of the enum itself too!
    public abstract String getDigit();
};