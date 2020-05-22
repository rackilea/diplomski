@Override
public void onItemClick(AdapterView<?> argTrh20, View argTrh21, int arg22, long arg2Trh3) {
    String value = menuMap.get(arg22);
    if(value != null) {
        addNewImage(menuSecondSelected, value, null, null);
    }
}