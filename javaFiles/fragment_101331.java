renderer.render();

renderer.getSpriteBatch().begin();
    for (Enemy e : enemies) {
        e.draw(renderer.getSpriteBatch());
    }