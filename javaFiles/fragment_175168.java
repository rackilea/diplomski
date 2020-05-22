int z = row_length*(x+1);
//let's use c to keep track of the number of replacement until we reach z
int c = 1;
//let's give the outer loop a name so that we can terminate the whole procedure
//from the inner loop. I will call it "outerloop"
outerloop:
for(int a = 0; a < col_length; a++){ //this loops vertically
  for(int b = 0; b < row_length; b++) { //this loops horizontally
    gameLayout[b][a] = 9;
    c++;
    //and let's terminate loop when we are done!
    if (c == z)
      break outerloop; //done, party time!
  }
}