public static void main(String[] args) {
        // This is the block of text to process.

        String block = text;
        System.out.println ("block    [" + block + "]");

        // Keep going until no more sentences.

        while (!block.equals("")) {
            // Remove leading spaces.

            if (block.startsWith(" ")) {
                block = block.substring(1);
                continue;
            }

            // Find end of sentence.

            int pos = block.indexOf('.');

            // Extract sentence and remove it from text block.

            String sentence = block.substring(0,pos);
            block = block.substring(pos+1);

            // Process the sentence (this is the "meat").

            procSentence (sentence);

            System.out.println ("block    [" + block + "]");
        }
        System.out.println ("==========");
    }
}