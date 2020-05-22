int spielfeldclone[][] = new int[spielfeld.length][];
 int i = 0;
 for(int[] spielfeldArray: spielfeld){
      spielfeldclone[i] =spielfeldArray.clone()lone();
      i++;
}
r= Computerzug(spielfeldclone,1,zug);