batch.end(); // Add the following after this line

sr.setProjectionMatrix(camera.combined);
sr.begin(ShapeType.Line);
sr.setColor(new Color(0,0,1,0));
sr.rect((mapPosX * Block.WIDTH), (mapPosY * Block.HEIGHT), Block.WIDTH, Block.HEIGHT));
sr.end();