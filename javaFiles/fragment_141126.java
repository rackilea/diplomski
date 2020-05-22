class Glass {
    ....
        public Glass () {
            this.ounce = 1;  
            /* In this setup, a glass always has at least 1 ounce */
            /* If you want it be 0, you could say this.ounce = 0, or */
            /* just leave everything inside {} blank, since ounce will */
            /* default to 0 anyway */
        }

        public Glass (int ounce) {
            this.ounce = ounce;
        }
    ....
    }