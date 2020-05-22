public void removeItem(Item item) { // -removes Item passed in: from ArrayList + GUI
    itemList.remove(item);
    window.remove(item);
    window.validate();
    window.repaint();
    runStore();
}