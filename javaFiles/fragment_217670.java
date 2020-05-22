// ***************************************************************
// Create the various context menus depending on which list it is from
// ***************************************************************
@Override
public void onCreateContextMenu(ContextMenu menu, View v,
        ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    switch (v.getId()) {
    case R.id.list1: {
        menu.setHeaderTitle("Tool CC Menu");
        menu.add(0, v.getId(), 0, "Edit/Add Cutter Comp Info");
        menu.add(0, v.getId(), 0, "Clear Cutter Comp Info");
        break;
    }
    case R.id.list2: {
        menu.setHeaderTitle("WPC Menu");
        menu.add(0, v.getId(), 0, "Edit WPC Info");
        menu.add(0, v.getId(), 0, "Clear WPC Info");
        break;
    }
    }
}
// ***************************************************************
// Create the various context menu actions based on which list
// ***************************************************************
@Override
public boolean onContextItemSelected(MenuItem item) {
    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
            .getMenuInfo();
    cc_id_int = (int) info.id;
    if (item.getTitle() == "Edit/Add Cutter Comp Info") {
        showDialog(CCEDIT_DIALOG_ID);
    } else if (item.getTitle() == "Clear Cutter Comp Info") {
        showDialog(CLEARCC_DIALOG_ID);
    } else if (item.getTitle() == "Edit WPC Info") {
        removeDialog(WPCEDIT_DIALOG_ID);
        showDialog(WPCEDIT_DIALOG_ID);
    } else if (item.getTitle() == "Clear WPC Info") {
        showDialog(CLEARWPC_DIALOG_ID);
    }
    return super.onContextItemSelected(item);
}