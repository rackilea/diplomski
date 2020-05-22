public Hra1()
{

    // Mince [] poleMinci = new Mince[20]; // **** not this ****
    poleMinci = new Mince[20]; // **** but this. note the difference? ****

    poleMinci[0] = new Mince("stříbrná", "coin.png");
    poleMinci[3] = new Mince("stříbrná", "coin.png");
    poleMinci[4] = new Mince("zlatá", "coin_gold.png");
    poleMinci[8] = new Mince("stříbrná", "coin.png");
    poleMinci[10] = new Mince("stříbrná", "coin.png");
    poleMinci[12] = new Mince("stříbrná", "coin.png");
}