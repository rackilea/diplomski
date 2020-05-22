String[] result = new String[arr.length - count];
int k = 0;
for (int i = 0; i < arr.length; i++) {
    if(!toRemove.equals(arr[i])){
       result[k] =  arr[i];
       k++;
    }

}
return result;