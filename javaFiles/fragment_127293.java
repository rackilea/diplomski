int randomColorIndex = rnd.nextInt(androidColors.length - 1);
if (randomColorIndex >= lastColorIndex) {
   ++randomColorIndex;
}
lastColorIndex = randomColorIndex;

button1.setBackgroundColor(androidColors[randomColorIndex]);