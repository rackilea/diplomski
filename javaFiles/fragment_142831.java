public void update(Point currLoc) {
    history.add(new Point(currLoc)); // new Point object added here

    for (Bots bot : bots) {
        bot.setLocationData(history);
        bot.update();
    }
}