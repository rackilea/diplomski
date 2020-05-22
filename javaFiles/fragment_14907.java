/*
 * @see IWorkbenchPreferencePage#init(IWorkbench)
 */
public void init(IWorkbench workbench) {
    //Initialize the preference store we wish to use
    setPreferenceStore(BadWordCheckerPlugin.getDefault().getPreferenceStore());
}

/**
 * Performs special processing when this page's Restore Defaults button has been pressed.
 * Sets the contents of the nameEntry field to
 * be the default 
 */
protected void performDefaults() {
    badWordList.setItems(BadWordCheckerPlugin.getDefault().getDefaultBadWordsPreference());
}
/** 
 * Method declared on IPreferencePage. Save the
 * author name to the preference store.
 */
public boolean performOk() {
    BadWordCheckerPlugin.getDefault().setBadWordsPreference(badWordList.getItems());
    return super.performOk();
}