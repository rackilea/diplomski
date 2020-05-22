// you can replace numberArray.length and stringArr.length with 3 if you want
for(int i = 0; i < numberArray.length; i++) {
    arr[i] = numberArray[i];
}
for(int i = 0; i < stringArr.length; i++) {
    arr[numberArray.length + i] = stringArr[i];
}

System.out.println(Arrays.toString(arr));