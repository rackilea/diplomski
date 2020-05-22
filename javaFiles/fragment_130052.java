private static final String[] images = {
        "https://i.imgur.com/g52UeNO.png",
        "https://i.imgur.com/kvHOLJ4.jpg",
};

ImageView imageView1 = new ImageView(images[0]);
ImageView imageView2 = new ImageView(images[1]);
StackPane sp = new StackPane(imageView1, imageView2);
Button button = new Button("", sp);