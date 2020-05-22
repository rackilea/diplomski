public boolean onContextItemSelected(MenuItem item) {
    if (item.getGroupId() == UNIQUE_FRAGMENT_GROUP_ID) {
        switch(item.getItemId()) {
        case MENU_OPTION_1: doSomething(); break;  
        case MENU_OPTION_2: doSomethingElse(); break;
    }
}