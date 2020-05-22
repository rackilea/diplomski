ImagePanel[] othelloPanels;

void changeImages(int[] indicies) {
    for (int i=0;i<indicies.length;i++) {
        othelloPanels[indicies[i]].change();
    }
}