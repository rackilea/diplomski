for (final String imageResource : imageResources) {
    String imagePath = getClass().getResource(imageResource).toExternalForm();
    ImageView imageView = new ImageView(new Image(imagePath));

    imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("You clicked: " + imagePath);
            File imageFile = new File(imagePath);
            Desktop.getDesktop().open(imageFile.getParentFile()); // open a folder in explorer 
            Desktop.getDesktop().open(imageFile); // open file with system preferred program
        }
    });
    tilePane.getChildren().add(imageView);
}