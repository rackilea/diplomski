public void transfer(Purse a, Purse b)
{

    for(String coin : a.coins){
        b.coins.add(coin);
        coins.remove(coin);
}