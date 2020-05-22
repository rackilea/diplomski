LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
for (int i = 0; i < options.length(); i++) {
    RadioButton option_view = new RadioButton(this);
    option_view.setText(option.getString("response"));
    radio_group.addView(option_view, params);
}