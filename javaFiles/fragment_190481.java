camera = new OrthographicCamera(50, 50);
camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
viewport = new ExtendViewport(camera.viewportWidth, camera.viewportHeight, camera);

// in render() method
batch.begin();
batch.draw(img, 0, 0, 100, 50);
batch.draw(img, -20, 0, 20, 20);
batch.end();