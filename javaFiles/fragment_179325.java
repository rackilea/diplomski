enum Heyo
{
  FirstVal, SecondVal
}

...later

int systemVal = [whatever];
Heyo enumVal = Heyo.values()[systemVal];

int againSystemVal = enumVal.ordinal();