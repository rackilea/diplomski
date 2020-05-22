for(Rectangle2D rect:rectList) {
    String pageNum = Integer.toString(n + 1);
    String x = Double.toString(rect.getX());
    String y = Double.toString(page_height - rect.getY()) ;
    String w = Double.toString(rect.getWidth());
    String h = Double.toString(rect.getHeight());
    writeToFile(pageNum, x, y, w, h, osw);
}