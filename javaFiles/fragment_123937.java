//I added these for posterity, I'm sure however you get these references is fine
LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
RadioGroup radio_group = new RadioGroup(this);
//Get the button, rename it, then add it to the group.
for(int i = 0; i < options.length(); i++) {
    JSONObject option = options.getJSONObject(i);

    RadioButton option_view = (RadioButton)vi.inflate(R.layout.poll_option, null);
    option_view.setText(option.getString("response"));

    radio_group.addView(button);
}