public void doMyUpdate() {
      if (SwingUtilities.isEventDispatchThread()) {
         clearStatisticButton.setEnabled(stat.hasEntries());
         minValueLabel.setText(stat.getMinValue());
      } else {
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               clearStatisticButton.setEnabled(stat.hasEntries());
               minValueLabel.setText(stat.getMinValue());
            }
         });
      }
      repaint(); // if the paintComponent method has more than just a super call.
   }