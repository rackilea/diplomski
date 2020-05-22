private void updateVotes(int choice) {
    if (votes.containsKey(lastChoice)) {
        votes.put(lastChoice, votes.get(lastChoice) - 1);
    }

    votes.put(choice, votes.get(choice) + 1);
    lastChoice = choice;

    // Update labels using the votes map here
}