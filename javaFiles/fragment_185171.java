//Background
game.batch.draw(background,0,0);
game.batch.draw(background_links,-background_links.getWidth(),0);
game.batch.draw(background_rechts,background.getWidth(),0);

    //Render Germans
for (germans germans : german) {
    germans.render(game.batch);
}