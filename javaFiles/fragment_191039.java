public static void renderSprites(List<List<AbstractSprite>> priorities){
    for (List<AbstractSprite> priority : priorities){
        for(AbstractSprite sprite : priority)){
           renderSprite(sprite);
        }
    }
}