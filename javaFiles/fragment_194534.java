sPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(kUp,"actionWhenKeyUp");
sPane.getActionMap().put("actionWhenKeyUp",
    new AbstractAction("keyUpAction")
    {
        public void actionPerformed(ActionEvent e)
        {
            final JScrollBar bar = sPane.getVerticalScrollBar();
            int currentValue = bar.getValue();
            bar.setValue(currentValue - increment);
        }
    }
);