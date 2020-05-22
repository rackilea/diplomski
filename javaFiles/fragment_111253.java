public static void fixTabRendering(TabPane tabs) {
    if (tabs.getTabClosingPolicy() != TabClosingPolicy.UNAVAILABLE) return;
    tabs.setTabClosingPolicy(TabClosingPolicy.SELECTED_TAB);
    for (Node node : tabs.lookupAll(".tab-close-button")) {
        // hide "close" button to imitate TabClosingPolicy.UNAVAILABLE
        node.setStyle("-fx-background-color:transparent;-fx-shape:null;-fx-pref-width:0.001");
    }
}