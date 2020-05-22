public ImageIcon getDieImage() {
        return img;
    }

    public void setImage() {
        for (int i = 0; i < 7; i++) {
            img = new ImageIcon("./src/images/" + i + ".png");
        }