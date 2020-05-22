Image image = null;
    try{
        URL url = new URL("https://i.imgur.com/itElfV3.jpg");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        image = new Image(inputStream);

    }catch (IOException e){
        e.printStackTrace();
    }

    Circle circle = new Circle(25);
    circle.setFill(new ImagePattern(image));