String[] arrayOne = {"65535", "00000", "00000", "00000", "00000",
        "A32CE", "43251", "98702", "ACED2", "98AAB",
        "00000", "00000", "00000", "65535", "65535"};

int validCounter = 0;
for(int i = 0; i < arrayOne.length; i++)
  if(!(arrayOne[i].equals("65535") || arrayOne[i].equals("00000")))
      validCounter++;

String[] arrayTwo = new String[validCounter];
int arrayTwoPos = 0;
for(int i = 0; i < arrayOne.length; i++)
  if(!(arrayOne[i].equals("65535") || arrayOne[i].equals("00000"))){
      arrayTwo[arrayTwoPos] = arrayOne[i];
      arrayTwoPos++;
  }

for(int i = 0; i < arrayTwo.length; i++)
    System.out.println(arrayTwo[i]);