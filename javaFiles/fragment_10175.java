for (int i = 0; i < str1Arr.length-1; i++){ // did you mean i < str1Arr.length ? 
       str1Number = Integer.valueOf(str1Arr[i]);
       str2Number = Integer.valueOf(str2Arr[i]);
       if (str1Number == str2Number) // <---- I've moved it to here 
            continue;
       if (str1Number > str2Number) {
             result = str1;
             break;
       } else {
             result = str2;
             break;
       }
}