Card processCard = ...;

for (Map.Entry<String, Integer> entry : processCard.actions.entrySet()) {
    // This loop will get each 'action' and 'value' that you added to
    // the HashSet for this card and process it.

    String action = entry.getKey();
    int value = entry.getValue();

    // Add the earlier 'card processing' code here...

    if (action.equals("money") {
        // Update user's money with value
    } else if (action.equals("move") {
        // Update user's position with value
    } else if (action.equals("...") {
        // and so on...
    }
}