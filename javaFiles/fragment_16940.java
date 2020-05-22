String name2 = "Hazel";
    String name = "Joshuaa";
    char[] lettersSoFar = new char[name.length() + name2.length()];

    char[] chars = name.toLowerCase(Locale.US).toCharArray();
    char[] chars2 = name2.toLowerCase(Locale.US).toCharArray();

    int count = 0;
    int lettersSoFarCount = 0;
    for (char firstCh : chars) {
        boolean isFirstOccurrence = true;
        for (char letter : lettersSoFar){
            if (letter == firstCh) {
                isFirstOccurrence = false;
                break;
            }
        }

        for (char secondCh : chars2) {
            if (firstCh == secondCh) {
                if (isFirstOccurrence) {
                    count += 2;
                    isFirstOccurrence = false;
                    lettersSoFar[lettersSoFarCount++] = firstCh;
                } else {
                    count++;
                }
            }
        }

    }