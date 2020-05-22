for (Enemy enemy : creator.getEnemies()) {
                enemy.update(dt);
                if (!enemy.destroyed && enemy.getX() < player.getX() + 272 / OscarinaBros.PPM) {
                    enemy.b2body.setActive(true);
                }
            }
            for (Item item : creator.getItems()) {
                item.update(dt);
                if (!item.destroyed && item.getX() < player.getX() + 272 / OscarinaBros.PPM) {
                    item.b2body.setActive(true);
                }
            }