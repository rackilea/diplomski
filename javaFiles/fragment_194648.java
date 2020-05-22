if(input.isKeyDown(Input.KEY_W)){
        PlayerY += delta * .1f;
    }
    if(input.isKeyDown(Input.KEY_S)){
        PlayerY -= delta * .1f;
    }

    if(input.isKeyDown(Input.KEY_A)){
        PlayerX -= delta * .1f;
    }
    if(input.isKeyDown(Input.KEY_D)){
        PlayerX += delta * .1f;
    }