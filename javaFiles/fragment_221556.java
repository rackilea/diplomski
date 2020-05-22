public static void procSentence (String sent) {
        System.out.println ("==========");
        System.out.println ("sentence [" + sent + "]");

        // Split sentence at whitspace into array.

        String [] sa = sent.split("\\s+");

        // Process each starting word.

        for (int i = 0; i < sa.length - 1; i++) {

            // Process each phrase.

            for (int j = i+1; j < sa.length; j++) {

                // Build the phrase.

                String phrase = sa[i];
                for (int k = i+1; k <= j; k++) {
                    phrase = phrase + " " + sa[k];
                }

                // This is where you have your phrase. I just
                // print it out but you can do whatever you
                // wish with it.
                System.out.println ("   " + phrase);
            }
        }
    }