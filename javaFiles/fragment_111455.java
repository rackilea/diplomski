private Integer myResult = null;

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (REQUEST_LOCATION == requestCode) {
        View root = getView();
        if (root != null) { // Consider also isResumed()
            // you can operate on your views
            applyLogicForResult(resultCode);
        } else {
            myResult = resultCode;
        }
    }
}

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) { // Consider also onResume()
    if (myResult != null) {
        applyLogicForResult(myResult);
        myResult = null;
    }
}