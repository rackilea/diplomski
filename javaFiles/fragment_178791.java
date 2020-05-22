private void seekToElement(HierarchicalStreamReader xpp, ArrayList<String> xpathishArray) {
    while(xpp.hasMoreChildren()) {
        xpp.moveDown();
        if(xpp.getNodeName().equals(xpathishArray.get(0))) {
            if(xpathishArray.size() > 1) {
                xpathishArray.remove(0);
                seekToElement(xpp, xpathishArray);
            }
            return;
        }
        xpp.moveUp();
    }
}