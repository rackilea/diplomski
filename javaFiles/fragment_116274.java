StringBuilder builder = new StringBuilder();
for (int i = 0; i < practice1.size(); i++) {
    if (i != 10) {
        builder += practice1.get(i);
    }
}
contextTextPane.setText(builder.toString());