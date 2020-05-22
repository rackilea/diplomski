// if the sizes aren't equal, a new raindrop must have been added!!
   if(raindrops.size() != raindropTextures.size())  {
     int random = MathUtils.random(0, 4);
     raindropTextures.add(someDrops.get(random));
   }        
   for(Rectangle raindrop: raindrops, Texture texture: raindropTextures) {
        // make sure the textures and raindrops correspond here; theoritically they should
        batch.draw(texture, raindrop.x, raindrop.y); 
   }