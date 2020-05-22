for (JRadioButton btn : listOfButtons) {
    if (btn.isSelected()) {
        Action action = mapOfActions.get(btn);
        action.actionPerformed(new ActionEvent(e, ActionEvent.ACTION_PERFORMED, null));
        break;
    }
}