case Colores:
    Color newColor = JColorChooser.showDialog(this, "Colors", color);
    if (newColor != null){
        color = newColor;
        repaint();
    }
    break;