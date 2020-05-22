public void paintComponent(Graphics g) {
      super.paintComponent(g);
      AttributedString as = new AttributedString("I love you 104 gazillion");
      as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 13, 14);
      as.addAttribute(TextAttribute.FOREGROUND, Color.RED, 2, 6);
      g.drawString(as.getIterator(), 20, 20);
   }