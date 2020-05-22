GameCardArrArr(Parcel in) {
   int numberOfArrays = in.readInt();
   mArray = new CGameCard[numberOfArays][];
   for (int i = 0; i < numberOfArrays; i++) {
      mArray[i] = (CGameCard[]) in.readParcelabeArray(CGameCard.class.getClassLoader());
   }
}