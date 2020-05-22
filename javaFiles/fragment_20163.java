@InverseBindingAdapter(attribute = "android:text")
public static int getIntText(TextView view) {
    try {
        return Integer.parseInt(view.getText().toString());
    } catch (NumberFormatException e) {
        return -1;
    }
}