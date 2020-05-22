public void appuyer() {
    AnchorPane arbre = null;
    try {
        arbre = FXMLLoader.load(getClass().getResource("noeud.fxml"));
        ((Pane) Main.root.lookup("#pdt")).getChildren().add(arbre);
        ((TextField) arbre.lookup("#nomnoeud")).setText(monNoeud.getNom());
        ((TextArea) arbre.lookup("#descnoeud")).setText(monNoeud.getDesc());
        ((TextField) arbre.lookup("#numfils")).setText(Integer.toString(monNoeud.numEnfants()));
        ((TextArea) Main.root.lookup("#txtaide")).setText("Cliquer pour voir/modifier le noeud.");
    } catch (IOException e) {
        e.printStackTrace();
    }

}