if (RandomNumber(delta) != 0){

        switch(rand.nextInt(4)){

        case 0:
            moveBy(3,0);
            break;
        case 1:
            moveBy(-3,0);
            break;
        case 2:
            moveBy(0,3);
            break;
        case 3:
            moveBy(0,-3);
            break;
    }
    }