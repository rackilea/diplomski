public void actionPerformed(ActionEvent e)
        {
            final JScrollBar bar = sPane.getVerticalScrollBar();
            int currentValue = bar.getValue();
            bar.setValue(currentValue - increment);
        }