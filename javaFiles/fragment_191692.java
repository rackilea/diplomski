mTabHost.setOnTabChangedListener(new OnTabChangeListener(){
@Override
public void onTabChanged(String tabId) {
    if(TAB_BUTTON_TAG.equals(tabId)) // TAB_BUTTON_TAG is the tag associated with your tab
    {
        Intent calcIntent = new Intent();
        calcIntent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
        startActivity(calcIntent);

    }

}});