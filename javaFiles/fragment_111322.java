public void render(float delta) {

    inputUpdate(touch, camera);

    if(TimeUtils.nanoTime() - lastSpawnTime > 1000000000) spawnChicken();  

    if(Gdx.input.isTouched()){
        touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(touch);


        if(farmerY <=  touch.y && touch.y<= farmerY + 170 && 
            farmerX  <=  touch.x && touch. x <= farmerX + 170){
        }else{
        if (touch.x - 85 > farmerX){
            farmerX +=5;
        }
        if (touch.x - 85 < farmerX){
            farmerX -=5;
        }
        if (touch.y - 85 > farmerY){
            farmerY +=5;
        }
        if (touch.y - 85 < farmerY){
            farmerY -=5;
        }
        }


    }

    if(Gdx.input.isKeyPressed(Keys.A)||Gdx.input.isKeyPressed(Keys.LEFT)){
        farmerX -= 10;
    }
    else if(Gdx.input.isKeyPressed(Keys.D)||Gdx.input.isKeyPressed(Keys.RIGHT)){
        farmerX += 10;  
    }
    else if(Gdx.input.isKeyPressed(Keys.W)||Gdx.input.isKeyPressed(Keys.UP)){
        farmerY += 10;
    }
    else if(Gdx.input.isKeyPressed(Keys.S)||Gdx.input.isKeyPressed(Keys.DOWN)){
        farmerY -= 10;  
    }

    if(farmerX < 0) farmerX = 0;
    if(farmerX > 1920-170) farmerX = 1920-170;
    if(farmerY < 0) farmerY = 0;
    if(farmerY > 1080-170) farmerY = 1080-170;
    farmer.x = farmerX;
    farmer.y = farmerY;

    camera.update();
    batch.setProjectionMatrix(camera.combined);

    Gdx.gl.glClearColor(0, 1, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    game.batch.begin();

    Iterator<Rectangle> iter = chickens.iterator();
    while(iter.hasNext()){  
        Rectangle chicken = iter.next();
        if(farmerX < (chicken.x - 85/2)) chicken.x -= 2.5;
        if(farmerX > (chicken.x - 85/2))chicken.x += 2.5;
        if (farmerY < (chicken.y - 66/2))chicken.y -= 2.5;
        if(farmerY > (chicken.y - 66/2))chicken.y += 2.5;

        float diffYchick;
        float diffXchick;
        float angleDegreeschick;

        diffYchick = (float) (farmerY - chicken.y);
        diffXchick = (float) (farmerX - chicken.x);

        angleDegreeschick = (float) Math.toDegrees(Math.atan2(diffYchick, diffXchick));

        game.batch.draw(chickenImage, (float)chicken.x, (float)chicken.y, (float)42.5, (float)33, (float)85, (float)66, (float)1, (float)1, (float)angleDegreeschick);

        int stop;
        stop = 0;
        switch(stop){
        case 0:
        if (chicken.overlaps(farmer)){
            System.out.print("GameOver");
            gameOver();

            stop +=1;
            break;
        }
        }

    }

    game.batch.end();

    float diffY = (float) (touch.y - farmerY);
    float diffX = (float) (touch.x - farmerX);

    float angleDegrees = (float) Math.toDegrees(Math.atan2(diffY, diffX));

    FarmerAsset.stateTime += Gdx.graphics.getDeltaTime();
    FarmerAsset.currentFrame = FarmerAsset.walkAnimation.getKeyFrame(FarmerAsset.stateTime, true);

    game.batch.begin();
    game.batch.draw(FarmerAsset.currentFrame, farmerX, farmerY, (float)85, (float)85, (float)170, (float)170, (float)1, (float)1, (float)angleDegrees + 270);
    game.font.draw(game.batch, "Chickens Running: " + runningChickens, 0, 1080);
    game.batch.end();

    }