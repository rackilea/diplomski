public void imagePicker(MouseEvent event) {
    event.consume();
    try {
        File file = new File("/home/zoran/eclipse-workspace/Pogodi tko sam/bin/application/iks.png");
        String localUrl = file.toURI().toURL().toString();
        Image image = new Image(localUrl);
        ((ImageView) event.getSource()).setImage(image); // set image on clicked ImageView
    } catch (MalformedURLException e) {
        System.out.println("Malformed url ex");
        e.printStackTrace();
    }           
}