int symptomsM = 867;
String symptomsBit = Integer.toBinaryString(symptomsM);
String[] symptomsBitArr = symptomsBit.split("");
System.out.println("symptomsBit: " + symptomsBit);
System.out.println("symptomsBitArray: " + symptomsBitArr);
int[] symptomsArray = new int[symptomsBitArr.length];
for (int i = 0; i < symptomsBitArr.length; i++) {
    symptomsArray[i] = Integer.parseInt(symptomsBitArr[i]);
    System.out.println("symptomsArray: " + symptomsArray[i]);
}