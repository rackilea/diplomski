while (sc.hasNextLine()) {
        String line = sc.nextLine();
        int tempCount = 0;
        int maxCount = 0;
        String maxLetter = "a";
        String alphabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
        for (int i = 0; i < alphabet.length() ; i++) {
            tempCount = 0;
            String lLetter = alphabet.charAt(i) + "";

            for (int a = 0; a < line.length(); a++) {
                if ((line.charAt(a) + "").equals(lLetter)) {
                    tempCount++;
                }
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
                maxLetter = lLetter;
            }
        }
        System.out.println(maxLetter + maxCount);
    }