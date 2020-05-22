public Color randomColor() {
        Random r = new Random();
        float red, green, blue;
        red = r.nextFloat();
        green = r.nextFloat();
        blue = r.nextFloat();
        return new Color(red, green, blue);
    }