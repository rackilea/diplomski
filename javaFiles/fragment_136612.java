private JToggleButton getToolRotateButton() {
        if (toolRotateButton == null) {
            RotateAction action = new RotateAction(this); //Code Added to fix

            toolRotateButton = new JToggleButton();
            toolRotateButton.setPreferredSize(dimension30x30);
            toolRotateButton.setHideActionText(true);
            toolRotateButton.setAction(action);
            toolRotateButton.setToolTipText("Rotate Bearings or Selected Items");
            toolRotateButton.addKeyListener(action.currentKeyEvent); //Code Added to fix
        }
        return toolRotateButton;
    }