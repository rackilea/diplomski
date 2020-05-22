static String proof(Object o) {
        for(int i = 0; i < 1; ++i) {
            if (o == null) {
                return "I'm returning from the for loop!!!";
            }
        }
        return "I'm now called after the for's return statement (by any means)!! - QED";
}