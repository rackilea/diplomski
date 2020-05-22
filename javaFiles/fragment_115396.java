private void drawGraph(Drawer drawer) {
    for(int i = 0; i < amountOfValues; i++) {
        MyObj obj = arrayList.get(i);
        drawer.draw(obj, g);
    }
}