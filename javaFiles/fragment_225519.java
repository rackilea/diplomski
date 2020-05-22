private void clearForm(ViewGroup formLayout) {
    for (int i = 0; i < formLayout.getChildCount(); i++) {
        View view = formLayout.getChildAt(i);
        if (view instanceof EditText) {
            ((EditText) view).getText().clear();
        }
    }
}