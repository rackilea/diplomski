public void paintHero(Graphics g) {

    offG.drawImage(heroCurrent, hero.getHeroX(), hero.getHeroY(), this);

    if (hero.getMoveX() == 0 && hero.getMoveY() == 0)
        heroFrame = 0;
    else {
        heroFrame++;
        if (heroFrame == 16)
            heroFrame = 0;
    }

    if (hero.isMovingUp()) {
        heroCurrent = heroSprites[4 + heroFrame / 4];
        offG.drawImage(heroCurrent, hero.getHeroX(), hero.getHeroY(), this);
    }
    if (hero.isMovingDown()) {
        heroCurrent = heroSprites[0 + heroFrame / 4];
        offG.drawImage(heroCurrent, hero.getHeroX(), hero.getHeroY(), this);
    }
    if (hero.isMovingLeft()) {
        heroCurrent = heroSprites[8 + heroFrame / 4];
        offG.drawImage(heroCurrent, hero.getHeroX(), hero.getHeroY(), this);
    }
    if (hero.isMovingRight()) {
        heroCurrent = heroSprites[12 + heroFrame / 4];
        offG.drawImage(heroCurrent, hero.getHeroX(), hero.getHeroY(), this);
    }
}