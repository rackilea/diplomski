T item = getItem(position);
 if (item instanceof CharSequence) {
   text.setText((CharSequence)item);

  } else {
    text.setText(item.toString());
 }