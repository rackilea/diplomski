private val isLineTooLong: String => Boolean = {
  val bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
  val graphics = bufferedImage.getGraphics

  val metrics = graphics.getFontMetrics(font)

  (line: String) => metrics.stringWidth(line) > imgWidth
}