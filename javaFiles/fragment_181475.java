Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
for (Font f : fonts) {
    if (f.canDisplay(66560)) {
        System.out.println(f);
        textField.setFont(f.deriveFont(20f));
    }
}