@FXML
public void getNewImageHandler(KeyEvent event) {
    if (event.getCode().equals(KeyCode.N)) {
        photoSwipeCounter++;
    }
    if (event.getCode().equals(KeyCode.P)) {
        photoSwipeCounter--;
    }

    // wrap around logic
    if (photoSwipeCounter < 0) {
        photoSwipeCounter = selectedImgsList.size() - 1;
    } else if (photoSwipeCounter >= selectedImgsList.size()) {
        photoSwipeCounter = 0;
    }

    singleFile = selectedImgsList.get(photoSwipeCounter);

    image = new Image(singleFile.toURI().toString(),
            900, 400,
            true, true, true);
    imgFieldView.setImage(image);
}