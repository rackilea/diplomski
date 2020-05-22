if (walking) {
        if (anim % 40 >= 30) {
            sprite = Sprite.playerF_2;
        else if (anim % 40 >= 20) {
            sprite = Sprite.playerF_1;
        } else if (anim % 40 >= 10) {
            sprite = Sprite.playerF_2;
        } else {
            sprite = Sprite.playerF_3;
        }
    }