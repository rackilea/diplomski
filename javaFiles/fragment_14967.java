ratew = guicam.viewportWidth/cam.viewportWidth;  //<--- you should calculate these 2 only once.
rateh = guicam.viewportHeight/cam.viewportHeight;

x = guicam.position.x-(cam.position.x-object.position.x)*ratew;
y = guicam.position.y-(cam.position.y-object.position.y)*rateh;
font.draw(batch, "stuff", x, y);