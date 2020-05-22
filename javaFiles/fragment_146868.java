matchingFontInfo.zipWithIndex.map {
  case (FontInfo(baseFont, file), index) =>
    val largerFont = baseFont.deriveFont(Font.PLAIN, 24)
    val label = new JLabel(s"[$index] ${baseFont.getFontName} : ${sampleText} (${file.getPath})")
    label.setFont(largerFont)
    // Add the label into a UI component ...
}