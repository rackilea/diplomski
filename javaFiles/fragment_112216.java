int[] intValues1 = ...;
int[] intValues2 = ...;
String[] stringValues = ...;
// if you are sure the arrays have the same length, this will work OK for you
for (int i = 0; i < intValues1.length; i++) {
    Card c = new Card(stringValues[i], intValues1[i], intValues2[i]);
    ...
}