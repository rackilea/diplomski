String[] arr = {"a","b",null,"c",null,"d"};

// This will move all elements "up" when nulls are found
int p = 0;
for (int i = 0; i < arr.length; i++) {
  if (arr[i] == null) continue;
  arr[p] = arr[i];
  p++;
}

// This will copy to a new smaller array
String[] newArr = new String[p];
System.arraycopy(arr,0,newArr,0,p);