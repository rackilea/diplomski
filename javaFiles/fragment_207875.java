HashMap<Integer, Button> buttons = new HashMap<Integer, Button>();
containerLayout = (LinearLayout) findViewById(R.id.containerLayout);
for (int i = 0; i < 6; i++) {
    Button button = new Button(this);
    button.setBackgroundResource(R.drawable.button);
    button.setTextAppearance(this, R.style.ButtonFontStyle);
    button.setTextColor(getResources().getColor(R.color.white));
    button.setTypeface(Typeface.DEFAULT_BOLD);
    button.setId(i);
    button.setText("test"+i);
    containerLayout.addView(button);
    buttons.put(i, button)
}
....
buttons.get(4).setText("changed4");