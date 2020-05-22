int numbers[] = new int[4];
int counter = 0;
int preselected = 0; //this would be set to anything from 0-4
for(int i = 0; i < 5; i++){
  if(i != preselected){
    numbers[counter] = i;
    counter++;
  }
}