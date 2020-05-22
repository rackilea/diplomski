restart = clientIn;
if (restart.contains("yes")) {
    run();
} else if (restart.contains("no")) {
    break;
} else if (!restart.equals("")) {
    for (int i = 0; i < maxClientsCount; i++) {
        if (threads[i] != null && threads[i] == this) {
            threads[i].os.println("Sorry I couldn't understand you. Please say yes or no.");
        }
    }
}