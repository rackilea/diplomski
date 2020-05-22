/**
* This method resizes the given image using Image.SCALE_SMOOTH.
*
* @param image the image to be resized
* @param width the desired width of the new image. Negative values force the only constraint to be height.
* @param height the desired height of the new image. Negative values force the only constraint to be width.
* @param max if true, sets the width and height as maximum heights and widths, if false, they are minimums.
* @return the resized image.
*/
public static Image resizeImage(Image image, int width, int height, boolean max) {
  if (width < 0 && height > 0) {
    return resizeImageBy(image, height, false);
  } else if (width > 0 && height < 0) {
    return resizeImageBy(image, width, true);
  } else if (width < 0 && height < 0) {
    PrinterHelper.printErr("Setting the image size to (width, height) of: ("
            + width + ", " + height + ") effectively means \"do nothing\"... Returning original image");
    return image;
    //alternatively you can use System.err.println("");
    //or you could just ignore this case
  }
  int currentHeight = image.getHeight(null);
  int currentWidth = image.getWidth(null);
  int expectedWidth = (height * currentWidth) / currentHeight;
  //Size will be set to the height
  //unless the expectedWidth is greater than the width and the constraint is maximum
  //or the expectedWidth is less than the width and the constraint is minimum
  int size = height;
  if (max && expectedWidth > width) {
    size = width;
  } else if (!max && expectedWidth < width) {
    size = width;
  }
  return resizeImageBy(image, size, (size == width));
}

/**
* Resizes the given image using Image.SCALE_SMOOTH.
*
* @param image the image to be resized
* @param size the size to resize the width/height by (see setWidth)
* @param setWidth whether the size applies to the height or to the width
* @return the resized image
*/
public static Image resizeImageBy(Image image, int size, boolean setWidth) {
  if (setWidth) {
    return image.getScaledInstance(size, -1, Image.SCALE_SMOOTH);
  } else {
    return image.getScaledInstance(-1, size, Image.SCALE_SMOOTH);
  }
}