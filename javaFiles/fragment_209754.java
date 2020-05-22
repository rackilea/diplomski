public boolean Roll() {

    ResourceManager.diceShake.play();

    Random rand = new Random();

    switch (rand.nextInt(6) + 1) {
    case 1:
        // dice_picture.setImageResource(R.drawable.one);
        dice1Sprite = new Dice(20, 20,
                ResourceManager.dieSideOneTextureRegion,
                ResourceManager.getInstance().engine
                        .getVertexBufferObjectManager());

        this.attachChild(dice1Sprite);

        break;
    case 2:
        // dice_picture.setImageResource(R.drawable.two);
        dice2Sprite = new Dice(40, 40,
                ResourceManager.dieSideTwoTextureRegion,
                ResourceManager.getInstance().engine
                        .getVertexBufferObjectManager());

        this.attachChild(dice2Sprite);

        break;
    case 3:
        // dice_picture.setImageResource(R.drawable.three);

        dice3Sprite = new Dice(60, 60,
                ResourceManager.dieSideThreeTextureRegion,
                ResourceManager.getInstance().engine
                        .getVertexBufferObjectManager());

        this.attachChild(dice3Sprite);

        break;
    case 4:
        // dice_picture.setImageResource(R.drawable.four);

        dice4Sprite = new Dice(80, 80,
                ResourceManager.dieSideFourTextureRegion,
                ResourceManager.getInstance().engine
                        .getVertexBufferObjectManager());

        this.attachChild(dice4Sprite);

        break;
    case 5:
        // dice_picture.setImageResource(R.drawable.five);

        dice5Sprite = new Dice(100, 100,
                ResourceManager.dieSideFiveTextureRegion,
                ResourceManager.getInstance().engine
                        .getVertexBufferObjectManager());

        this.attachChild(dice5Sprite);

        break;
    case 6:
        // dice_picture.setImageResource(R.drawable.six);

        dice6Sprite = new Dice(120, 120,
                ResourceManager.dieSideSixTextureRegion,
                ResourceManager.getInstance().engine
                        .getVertexBufferObjectManager());

        SceneManager.getInstance().mCurrentScene.attachChild(dice6Sprite);

        break;
    default:
    }

    rolling = false; // user can press again

    this.sortChildren();
    return true;

}