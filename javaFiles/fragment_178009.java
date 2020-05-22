public boolean hideKeyboard() {
    View view = this.getActivity().getCurrentFocus();
    if (view != null) {
        InputMethodManager imm = (InputMethodManager) ((this.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)));
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        return true;
    }
    return false;
}