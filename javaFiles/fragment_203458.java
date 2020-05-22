.....
 @Override
 public void onViewCreated(View view, @Nullable Bundle savedInstanceState) { 
    EditText editText = view.findViewById(R.id.et);
    editText.requestFocus();
    InputMethodManager imgr = (InputMethodManager) 
    getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    imgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
}
...