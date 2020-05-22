public void onSectionAttached(int number) {
    String[] stringArray = getResources().getStringArray(R.array.section_titles);
    if (number >= 1) {
        mTitle = stringArray[number - 1];
    }
}