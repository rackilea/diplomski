public int score(Item item, String query) {
    int score = 0;

    if (item.userId().startsWith(query) {
        score += 2000;
    }
    if (item.lastName().startsWith(query) {
        score += 200;
    } else if (item.lastName().contains(query) {
        score += 100;
    }
    if (item.email().startsWith(query) {
        score += 20;
    } else if (item.email().contains(query) {
        score += 10;
    }
    if (item.userType().equals("VET")) {
        score += 5;
    }

    return score;
}