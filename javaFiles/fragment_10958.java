//Change the text to White here <- Causing Border Issues
            g.setColor(Color.WHITE);

            SwingUtilities2.drawStringUnderlineCharAt(tabPane, g,
                    title, mnemIndex,
                    textRect.x, textRect.y + metrics.getAscent());

            //reset the color to selectedColor
            g.setColor(selectColor);