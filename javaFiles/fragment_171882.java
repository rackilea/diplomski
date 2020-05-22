int fanta = 1;
int crisps = 1;
int beer = 2;
int wine = 3;
int water = 0;

...

if(btnFanta.isSelected()) fanta++;
if(btnCrisps.isSelected()) crisps++;
if(btnBeer.isSelected()) beer++;
if(btnWine.isSelected()) wine++;
if(btnWater.isSelected()) water++;

rs.updateInt("TotalCost", fanta + crisps + beer + wine + water);