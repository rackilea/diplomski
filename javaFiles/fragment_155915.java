void writeToParcel(Parcel dest, int flags) {
   int numOfArrays = mArray.length;
   dest.writeInt(numOfArrays); // save number of arrays
   for (int i = 0; i < numOfArrays; i++) {
      dest.writeParcelableArray(mArray[i], flags);
   }
}