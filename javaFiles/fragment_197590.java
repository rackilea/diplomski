public void onUpdate() {


    if (player.getTranslateY() > 100) {
        Rectangle dummy = new Rectangle();
        group.getChildren().add(dummy);
        group.getChildren().remove(player);
        group.getChildren().remove(dummy);
    } else {
        player.setTranslateX(player.getTranslateX() + 1);
        player.setTranslateY(player.getTranslateY() + 1);
    }
}