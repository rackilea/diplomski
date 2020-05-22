private EditText findInput(ViewGroup np) {
    int count = np.getChildCount();
    for (int i = 0; i < count; i++) {
        final View child = np.getChildAt(i);
        if (child instanceof ViewGroup) {
            findInput((ViewGroup) child);
        } else if (child instanceof EditText) {
            return (EditText) child;
        }
    }
    return null;
}