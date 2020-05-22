//Converts every letter in string to ascii and normalizes it (90/asciiValue)    
     public static double[] toAscii(String s, int najveci) {
            double[] ascii = new double[najveci];
            try {
                    byte[] bytes = s.getBytes("US-ASCII");
                    for (int i = 0; i < bytes.length; i++) {
                            ascii[i] = 90.0 / bytes[i];
                    }

            } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
            }
            return ascii;
    }