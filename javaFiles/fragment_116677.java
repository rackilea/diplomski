List<JCheckBox> buttons = new ArrayList<>();
buttons.add(c1);
buttons.add(c2);
buttons.add(c3);

...

for ( JCheckbox checkbox : buttons ) {
    if( checkbox.isSelected() )
    {
        SelectedItem += btn.getText() + ",";
    }
}