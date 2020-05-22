int newCount = 0;
while(iter.hasNext()){
    Coin coin = iter.next();
    if(getBounds().intersects(coin.getBounds())){
        Game.Points++;
        newCount++
        iter.remove();
    }
}
for(int i = 0; i < newCount; i++){
    c.add(new Coin());
}