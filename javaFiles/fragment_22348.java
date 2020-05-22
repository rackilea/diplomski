int pageRotation = page.getRotation();
PDRectangle pageCropBox = page.getCropBox();

for(Rectangle2D rect:rectList) {
    String pageNum = Integer.toString(n + 1);
    String x, y, w, h;
    switch(pageRotation) {
    case 0:
        x = Double.toString(rect.getX() - pageCropBox.getLowerLeftX());
        y = Double.toString(pageCropBox.getUpperRightY() - rect.getY() + rect.getHeight());
        w = Double.toString(rect.getWidth());
        h = Double.toString(rect.getHeight());
        break;
    case 90:
        x = Double.toString(rect.getY() - pageCropBox.getLowerLeftY());
        y = Double.toString(rect.getX() - pageCropBox.getLowerLeftX());
        w = Double.toString(rect.getHeight());
        h = Double.toString(rect.getWidth());
        break;
    case 180:
        x = Double.toString(pageCropBox.getUpperRightX() - rect.getX() - rect.getWidth());
        y = Double.toString(rect.getY() - pageCropBox.getLowerLeftY());
        w = Double.toString(rect.getWidth());
        h = Double.toString(rect.getHeight());
        break;
    case 270:
        x = Double.toString(pageCropBox.getUpperRightY() - rect.getY() + rect.getHeight());
        y = Double.toString(pageCropBox.getUpperRightX() - rect.getX() - rect.getWidth());
        w = Double.toString(rect.getHeight());
        h = Double.toString(rect.getWidth());
        break;
    default:
        throw new IOException(String.format("Unsupported page rotation %d on page %d.", pageRotation, page));
    }
    writeToFile(pageNum, x, y, w, h, osw);
}