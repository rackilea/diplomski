Vector3 PosHero = new Vector3();
PosHero.set(hero.bodyHero.getPosition().x, hero.bodyHero.getPosition().y, 0);
camera.project(PosHero);

posX = PosHero.x/camera.viewportWidth;
posY = PosHero.y/camera.viewportHeight;

shaderProgram.begin();
shaderProgram.setUniformf("u_PosX", posX);
shaderProgram.setUniformf("u_PosY", posY);
shaderProgram.end();