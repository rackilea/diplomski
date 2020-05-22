openColourDetectorActivity(pictureFile);

public void openColourDetectorActivity(File file) {
    Intent intent = new Intent(this, ColourDetectorActivity.class);
    intent.putExtra("FILE", file.getPath());
    startActivity(intent);
}