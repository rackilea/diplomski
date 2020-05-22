ArrayList<Beam> toBeRemoveBeams = new ArrayList<Beam>();
ArrayList<Sprite> toBeRemoveSprites = new ArrayList<Sprite>();
for(Beam bullet: beam){
    for(Sprite sprite: sprites){
        if(checkCollision(sprite, bullet)){
            toBeRemoveBeams.add(beam);
            toBeRemoveSprites.add(sprite);
            mScore = mScore + 1;
            break;
        }               
    }
}
beam.removeAll(toBeRemoveBeams);
sprites.removeAll(toBeRemoveSprites );