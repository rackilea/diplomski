//for loop to to across the x - getWidth() might be useful
for(int x = 30; x <= getWidth()- 30; x+=15){
    for(int y = 100; y <= getHeight() - 30; y+= 15){
        int colorValue1 = (int)(Math.random() * 256);
        int colorValue2 = (int)(Math.random() * 256);
        int colorValue3 = (int)(Math.random() * 256);

        Color random = new Color(colorValue1, colorValue2, colorValue3);
        window.setColor(random);

        window.fillRect(x, y, 8, 8);
    }
}