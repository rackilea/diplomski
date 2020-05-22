for(GameObject t : enemies){
        int direction = 0;
        for(GameObject t2 : list){
            if(t2 instanceof Brick){
                if(t.hits2(t2.getHitBox()) == 2){
                    direction = 2;
                }else if(t.hits2(t2.getHitBox()) == 3){
                    direction = 1;
                }
            }
        }
        t.update(Gdx.graphics.getDeltaTime(), direction);
        switch(t.hits(player1.getHitBox())){
        case 4:
            SoundManager.kill.play(.03f);
            deleteEnemy.add(t);
            break;
        case 5:
            player1.setPosition(0, 400);
            dead++;
            SoundManager.dead.play(0.06f);
            gameState = 4;
            break;
        }
      //break; Remove this
     }