g1 =f1; //desn't work
    f1 = g1; // now f1 points to g1 and you can treat the object g1 like a flower object
    g1=v; // doesn't work
    v=(Violet)f2; //desn't work
    g2=f1; //doesn't work, but since now f1 has a Gardenia object, you can make it work doing g2 = (Gardenia) f1 
    g1=f2; //doesn't work