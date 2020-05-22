// create a newArray before of the same size as array

// copy
for(int x = 0; x <= array.length-1; x++){
  newArray[(x+a) % array.length ] = array[x];
}