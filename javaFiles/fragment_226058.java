this.renderer.setView(scrollingCamera);
this.renderer.render(); // Render tiles
this.scrollingCamera.translate(SCROLLING_SPEED.X, SCROLLING_SPEED.Y);
this.scrollingCamera.update();

this.renderer.setView(camera);
// Render other stuff
camera.update();