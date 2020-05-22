for (int i = 0; i < layerStrings.length; i++) {
        JLabel label = createColoredLabel(layerStrings[i],
                                          layerColors[i], origin);
        layeredPane.add(label, new Integer(i));
        origin.x += offset;
        origin.y += offset;

  label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // added
    }