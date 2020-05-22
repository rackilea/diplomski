for (int i = 0; i < arr.length - 2; i++) { 
     if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) { 
        return true; 
     }
}
return false;