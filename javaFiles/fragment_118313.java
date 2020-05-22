private LinkedList<MailItem> items;

public void post(MailItem item) {
    if(!isEmpty(item)){
        items.addFirst(item);
    }
}