count = 0;
for (int i : numb){
  if (i == key){
    count++;
  } else {
    count = 0;
  }
  if(largest<count) {
    largest = count;
  }
}