@BindingAdapter({"name_text"})
public static void setName(TextView textView, Name name) {
    String string = String.valueOf((name.title).charAt(0)).toUpperCase() + name.title.substring(1)
            + " " + String.valueOf((name.first).charAt(0)).toUpperCase() + name.first.substring(1)
            + " " + String.valueOf((name.last).charAt(0)).toUpperCase() + name.last.substring(1);
    textView.setText(string);
}