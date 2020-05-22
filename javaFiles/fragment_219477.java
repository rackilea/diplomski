for(int i=0; i<contactList.size; i++) {
    if(delete.id == contactList[i].id) {
        contactList[i] = null;
        break;
    }
}