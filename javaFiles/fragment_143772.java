public void setTranslation(int translationX, int translationY)
{
    this.translationX = translationX;
    this.translationY = translationY;
}

...

//hexagon.translate(10, 10);
hexagon.translate(translateX, translateY);

...

Hexagon hex = new Hexagon();
hex.setTranslation(10, 10);