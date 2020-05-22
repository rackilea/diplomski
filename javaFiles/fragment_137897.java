boolean invoke =
               (adjusting != getValueIsAdjusting()) && !adjusting;
        super.setRangeProperties(newValue, newExtent, newMin, newMax, adjusting);
        if (invoke) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    fireStateChanged();   
                }
            });
        }