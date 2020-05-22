public static void countTimesWordApperesInArray() {
        int size = words.length;
        for (int i = 0; i < size; i += 1) {
            int count = 0;

            String element = words[i];
            for (int j = 0; j < size; j += 1) {
                if (words[j].equals(element)) {
                    count += 1;
                }
            }
            System.out.println(words[i] + " " + count);
        }
    }