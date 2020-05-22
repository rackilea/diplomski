class FieldLabel extends JLabel {
        FieldLabel(String text) {
            super("<html>"+text);
        }
        Rectangle getTextBounds() {
            JLabel.AccessibleJLabel acclab 
                = (JLabel.AccessibleJLabel) getAccessibleContext();
            if (acclab.getCharCount() <= 0)
                return null;
            Rectangle r0 = acclab.getCharacterBounds(0);
            Rectangle rn = acclab
                .getCharacterBounds(acclab.getCharCount()-1);

            return new Rectangle(r0.x, r0.y, 
                    rn.x+rn.width-r0.x, Math.max(r0.height, rn.height));
        }
    }