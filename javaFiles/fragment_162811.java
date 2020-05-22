String[] arr = new String[al.size() + 1];
arr[0] = someStr;  // initial string

// copy the list:
System.arraycopy(al.toArray(), 0, arr, 1, al.size());

return arr;