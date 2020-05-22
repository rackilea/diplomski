Integer foundIndex = null;
for (String value : list) {
    if (value.contains(keyword)) {
        foundIndex = list.indexOf(value);
        break; // we stop iteration because we got our result
    }
}

boolean found = (foundIndex!=null);
if (found) {
   //....
} else {
  //....
}