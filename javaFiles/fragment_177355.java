open.setOnAction(new EventHandler<ActionEvent>() {

    public void handle(ActionEvent event) throws MalformedURLException  {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        File selectedFile = fileChooser.showOpenDialog(null);

       if (selectedFile != null) {
          //you can set your image to a Image view 
          imageView.setImage(new Image(selectedFile.toURI().toURL().toExternalForm()));
          //or else you can reassign your image path to a string variable so that you can re-use that String variable in all over the class 
          path = selectedFile.toURI().toURL().toExternalForm();  
       }else {
        System.out.println("Error Selection");
       }