v5 = (byte) (key[4] + key[8 + v3]);
v6 = key[8 + v3];
key[8 + v3] = key[8 + v5];
key[8 + key[4]] = v6; 

....key[8 + (byte)(key[8 + key[4]] + key[8 + key[0]])]