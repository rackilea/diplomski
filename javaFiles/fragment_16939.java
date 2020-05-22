String name = "Hazel";
    String name2 = "Joshuaa";
    Set<Character> lettersSoFar = new HashSet<>();

    char[] chars = name.toLowerCase(Locale.US).toCharArray();
    char[] chars2 = name2.toLowerCase(Locale.US).toCharArray();

    int count = 0;
    for (char firstCh : chars) {
        boolean isFirstOccurrence = !lettersSoFar.contains(firstCh);
        for (char secondCh : chars2) {
            if (firstCh == secondCh) {
                if (isFirstOccurrence) {
                    count += 2;
                    isFirstOccurrence = false;
                    lettersSoFar.add(firstCh);
                } else {
                    count++;
                }
            }
        }
    }