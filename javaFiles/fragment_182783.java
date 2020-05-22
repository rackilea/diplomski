RenderingHints qualityHints = new RenderingHints(
  RenderingHints.KEY_ANTIALIASING,
  RenderingHints.VALUE_ANTIALIAS_ON );
qualityHints.put(
  RenderingHints.KEY_RENDERING,
  RenderingHints.VALUE_RENDER_QUALITY );
g2.setRenderingHints( qualityHints );