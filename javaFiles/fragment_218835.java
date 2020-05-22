for(Coin coin : coins){
    if(player.collidesWith(coin)){
        playSound();
        coins.remove(coin, true);
    }
}