ImageIcon selectedIcon = new ImageIcon("Image.png");
Image image = selectedIcon.getImage();
PlaceHolderIcon placeHolderIcon = new PlaceHolderIcon(image.getWidth(this), image.getHeight(this));
JToggleButton layoutButton = new JToggleButton();
layoutButton.setIcon(placeHolderIcon);
layoutButton.setFocusPainted(false);
layoutButton.setSelectedIcon(selectedIcon);