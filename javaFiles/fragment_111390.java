int item = 0;

for (int i = 0; i < length; i++) {

    if (checked.get(i)) {
        onList.add(jsonList.get(item));
        jsonList.remove(item);
        lv_Devices.setItemChecked(i, false);
    }
    else {
        item++;
    }
}