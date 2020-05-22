Peon[] peons = new Peon[8];
for (int j = 0; j < 8; j++) 
{
    Boton[1][j].setIcon(PeonN);
    peons[j] = new Peon('N');
    Boton[6][j].setIcon(PeonB);
}

// So we can access a single peon like this
Peon p3 = peons[3];

// Or iterate over all peons and get the cycle number like this
for (int cycle_num = 0; cycle_num < 8; cycle_num++) {
    Peon peon = peons[cycle_num];

    // Do something with peon and cycle_num here

}