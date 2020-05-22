@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    if(position < menuValues.length) { // this is just a defensive check. If you are sure the array is the same length as the max amount of items, this can be omitted.
        addNewImage(menuSecondSelected, menuValues[position], null, null);
    }
}