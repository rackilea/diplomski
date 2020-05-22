String start = getText().substring(0, startOfHighlight);
  String text = getText().substring(startOfHighlight, endOfHighlight);
  //You may also need to account for some offsets here:
  int startX = metrics.stringWidth(start);
  int startY = 0; //You probably have some vertical offset to add here.
  int length = metrics.stringWidth(text);
  int height = metrics.getHeight();