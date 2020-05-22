if (mouseOver(mx, my, 220, 140, 40, 20)){       //Assume this position is fixed
    AudioPlayer.getSound("menu_sound").play();
    if (HUD.money >= UpgradePrices.potPrice){
        HUD.money -= UpgradePrices.potPrice;
        HUD.pots += 1;
    }
    for(int x=0; x<HUD.pots; x++){             //Once again, this will replace all the ifs
        handler.addObject(new Pot(( 230+(x*50), 502, ID.Pot, handler )))
    }
}