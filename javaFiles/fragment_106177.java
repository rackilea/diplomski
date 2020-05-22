if ( comboBox.isEnabled() ) {
            c.setForeground(comboBox.getForeground());
            c.setBackground(comboBox.getBackground());
        }
        else {
            c.setForeground(DefaultLookup.getColor(
                     comboBox, this, "ComboBox.disabledForeground", null));
            c.setBackground(DefaultLookup.getColor(
                     comboBox, this, "ComboBox.disabledBackground", null));
        }