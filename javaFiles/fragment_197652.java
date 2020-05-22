Random random = new Random(seriesIndex);
int red = random.nextInt(256);
int green = random.nextInt(256);
int blue = random.nextInt(256);

// mix the color
if (MIX != null) {
    red = (red + MIX.getRed()) / 2;
    green = (green + MIX.getGreen()) / 2;
    blue = (blue + MIX.getBlue()) / 2;
}

Color c = new Color(red, green, blue);