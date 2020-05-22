sRDebugRectangelPlayer.begin(ShapeType.Filled);
sRDebugRectangelPlayer.identity();

sRDebugRectangelPlayer.rect(player.getxPos(), player.getyPos(),
                           player.getSprite().getWidth(),
                           player.getSprite().getHeight());

sRDebugRectangelPlayer.end();