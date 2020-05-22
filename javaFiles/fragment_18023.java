String[] arr = {"5", "7", "a", "1", "g", "b"};
String[] numberArray = new String[3];
// keep this as a String[] for simpler concatenation of the arrays later

String[] stringArr = new String[3];

/*if you do not know that there will be exactly 3 of each, 
  just write arr.length isntead of 3*/

for(int i = 0; i < arr.length; i++) {
    int numberIndex = 0;
    int stringIndex = 0;
    try {
        Integer.parseInt(arr[i]);
        numberArray[numberIndex] = arr[i];
        numberIndex++;
    } catch (Exception e) {
        String s = arr[i];
        stringArr[stringIndex] = s;
        stringIndex++;
    }
}
Arrays.sort(stringArr);
Arrays.sort(numberArray);