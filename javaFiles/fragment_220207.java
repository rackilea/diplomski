int[] state1 = new int[list.size()];
    for (int i = 0; i < list.size; i++) {
        // state1[i] = 0; // Not needed already 0.
        String wordToSearchFor = state[i];
        for (String state2 : list) {
            if (state2.equals(wordToSearchFor)) {
                state1[i]++;
            }
        }
        System.out.println(state[i] + "="  + "["+ Vermont +"]");
    }