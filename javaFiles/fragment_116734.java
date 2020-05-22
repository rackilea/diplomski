@Override
public Color getBackground() {
    int randomNum1 = rand.nextInt(251);
    int randomNum2 = rand.nextInt(251);
    int randomNum3 = rand.nextInt(251);
    Color color = new Color(randomNum1, randomNum2, randomNum3);
    return color;
}