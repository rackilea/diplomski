protected void setBorderToRollover(Component c) {
        if (c instanceof AbstractButton) {
            AbstractButton b = (AbstractButton)c;

            Border border = borderTable.get(b);
            if (border == null || border instanceof UIResource) {
                borderTable.put(b, b.getBorder());
            }

            // Only set the border if its the default border
            if (b.getBorder() instanceof UIResource) {
                b.setBorder(getRolloverBorder(b));
            }

            rolloverTable.put(b, b.isRolloverEnabled()?
                              Boolean.TRUE: Boolean.FALSE);
            b.setRolloverEnabled(true);
        }
    }