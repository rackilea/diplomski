...
gc.setRenderingHints(rh);
gc.setComposite(AlphaComposite.Clear);
gc.fillRect(0, 0, diameter, diameter);
gc.setComposite(AlphaComposite.Src);
gc.setColor(outsideColor);
...