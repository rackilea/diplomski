// This is actually a cool one-liner:
SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        Collection<Object> objects = doSomethingIntense();
        this.myJList.clear();
        for(Object o : objects) {
            this.myJList.addElement(o);
        }
    }
});