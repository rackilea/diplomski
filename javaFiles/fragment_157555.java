float deltaTime = Gdx.graphics.getDeltaTime();

Iterator<Rocket> iter = rockets.iterator();
while(iter.hasNext()) {

    Rocket rocket = iter.next();
    rocket.y -= 140 * deltaTime;

    if (!rocket.exploded){

        if(rocket.y + 32 < 0) {
            iter.remove();
            continue;
        }

        if (rocket.x - 5 < tap_X && tap_X < rocket.x + rocket.width + 5) {

            if (tap_Y > rocket.y - 5 && tap_Y < rocket.y + rocket.height + 5) {
                rocket.exploded = true;
                rocket.explosionAge = -deltaTime; //This is so the first frame will start from 0, since deltaTime is added before it's drawn below
            }
        }
    }

    if (rocket.exploded){
        rocket.explosionAge += deltaTime;
        if (rocket.explosionAge > AssetLoader.explosionA.getAnimationDuration()){
            iter.remove();
            continue;
        }

        batch.draw(AssetLoader.explosionA.getKeyFrame(rocket.explostionAge, false), 
            rocket.x, rocket.y, rocket.width, rocket.height);
    } else {
        batch.draw(AssetLoader.rocket, 
            rocket.x, rocket.y, rocket.width, rocket.height);
    }
}