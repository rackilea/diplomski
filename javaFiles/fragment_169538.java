private static List<String> draw(String ballPrefix, int noOfBalls, int noToDraw) {
    List<String> balls = new ArrayList<>();
    for (int ballNo = 1; ballNo <= noOfBalls; ballNo++)
        balls.add(ballPrefix + ballNo);
    Collections.shuffle(balls);
    return balls.subList(0, noToDraw);
}