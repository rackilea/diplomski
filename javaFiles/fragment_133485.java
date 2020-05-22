// Create the File where the photo should go
    File photoFile = null;
    try {
        photoFile = createImageFile();
    } catch (IOException ex) {
        // Error occurred while creating the File
        ...
    }