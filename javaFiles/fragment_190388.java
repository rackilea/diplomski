public Hra1()
{
    // the following variable's *scope* is inside of this constructor only
    // outside of the constructor, the local variable below doesn't exist.
    Mince [] poleMinci = new Mince[20]; 

    poleMinci[0] = new Mince("stříbrná", "coin.png");
    poleMinci[3] = new Mince("stříbrná", "coin.png");
    poleMinci[4] = new Mince("zlatá", "coin_gold.png");
    poleMinci[8] = new Mince("stříbrná", "coin.png");
    poleMinci[10] = new Mince("stříbrná", "coin.png");
    poleMinci[12] = new Mince("stříbrná", "coin.png");
}