ParseObject gallery =  object.getParseObject("ImgName");
if (gallery != null) {
    String name=gallery.getString("name");
    TextView nameTextView = (TextView) v.findViewById(R.id.text);
    nameTextView.setText(name);
} else {
    nameTextView.setText(""); // or any other default value you want to set
}