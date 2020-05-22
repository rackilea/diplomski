int newLine = 3;
int multiplicator = 1;
for(int i = 0; i< names.length; i++){
  if( newLine == i){
    // print extra line after every 3rd output        
    field.append("\n");
    newLine = 3; //to reset variable to the correct delimiter on each subsequent n-th iteration
    multiplicator++;
    newLine = newLine * multiplicator;
  }
field.append(names[i] + "\n")
// print regular value on normal line during every iteration
}