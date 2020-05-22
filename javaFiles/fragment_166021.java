//your specific ROOT layout : linear, relative, constraint etc which is to contain this button
LinearLayout layout = (LinearLayout)findViewById(R.id.layout);

public boolean doesButtonExist (LinearLayout layout) {
    for (int i = 0; i < layout.getChildCount(); i++) {
        View view = layout.getChildAt(i);
        if (view instanceof Button) {
            //here, you can check the id of the view
            //you can call: view.getId() and check if this is the id of the button you want
            //you can also change the properties of this button here, if you DO find it
            //do something like return true
        }
    }
    return false;
}