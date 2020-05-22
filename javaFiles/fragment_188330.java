// Define the portion / row size 50px or 100px
int rowHeight = 50;
int rowsToScan = imageHeight / rowHeight;
if(imageHeight % rowHeight > 0) rowsToScan++;

int x = 0;
int y = 0;
int w = imageWidth;
int h = rowHeight;

ArrayList<BufferedImage> scaledImagePortions = new ArrayList<>();

for(int i = 1; i <= rowsToScan; i++) {
    // Read the portion of an image scale it
    // and push the scaled version in lets say array
    BufferedImage scalledPortionOfImage = this.getScaledPortionOfImage(img, x, y, w, h);
    scaledImagePortions.add(scalledPortionOfImage);

    y = (rowHeight * i);
}

// Create single image out of scaled images portions