//Load your font from file
Font myFont = Font.createFont(Font.TRUETYPE_FONT, myClass.class.getClass().getResource("/res/Template/GOTHIC.TTF").openStream());
//set the style and size
myFont = myFont.deriveFont(style, size);
//Now use the font
myTextArea.setFont(myFont);