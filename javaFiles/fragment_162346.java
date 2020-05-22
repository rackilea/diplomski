if (code==KeyEvent.VK_LEFT) {
            trans.setToIdentity();
            player.moveLeft();
            trans.translate(player.x-shipImg.getWidth()/2,player.y-shipImg.getHeight()/2);
            trans.rotate(player.angle-1.57, shipImg.getWidth()/2, shipImg.getHeight()/2);
        }