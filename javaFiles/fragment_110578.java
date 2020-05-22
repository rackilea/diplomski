void draw() {
    background(170);

    // refreshes the players blob wherever the cursor is! 
    myBlob.setX(mouseX);
    myBlob.setY(mouseY);
    myBlob.display();

    // display the other blobs on the screen
    for (Blob boxes : blobs) {
        boxes.display();
        boxes.dragging();
    }
}