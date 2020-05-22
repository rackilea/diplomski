for (int i = 0; i < amount; i++) {
    Player player = ...;
    player.join();

    try {
        Thread.sleep(delay);
    } catch (InterruptedException reallyIgnored) {}
}