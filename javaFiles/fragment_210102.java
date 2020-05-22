sprite.begin();
world.draw(sprite);
sprite.end();

camera.update();
sprite.setProjectionMatrix(camera.combined);