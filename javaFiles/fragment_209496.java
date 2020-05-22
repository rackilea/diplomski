result = result.toLowerCase();
    searchStr = searchStr.toLowerCase();

    String[] resultWords = result.split(" ");
    String[] searchWords = searchStr.split(" ");
    int score = 0;
    for (String resultWord : resultWords) {
        boolean exactMatch = false;
        for (String searchWord : searchWords) {
            if (!exactMatch && resultWord.equals(searchWord)) {
                exactMatch = true;
                score += 3;
            } else if (resultWord.contains(searchWord))
                score++;
        }
    }