if(gearsFactory.getPermission()) {
    RootPanel titleBarRight = RootPanel.get("titleBarRight");
    java.util.Iterator<Widget> itr = titleBarRight.iterator();
    while(itr.hasNext()) {
        itr.next();
        itr.remove();
    }
}