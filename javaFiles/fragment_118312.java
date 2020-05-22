public MailItem getNextMailItem(String who) {
    ListIterator<MailItem> it = items.listIterator(items.size());
    while(it.hasPrevious()) {
        MailItem item = it.previous();
        if(item.getTo().equals(who)) {
            it.remove();
            return item;
        }
    }
    return null;
}