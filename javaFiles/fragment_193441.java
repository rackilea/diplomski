int consecutiveZeros = 0;

for(int i=0; i< input.length; i++) {
  if(input[i] == 0) {
    consecutiveZeros++;
  } else {
    consecutiveZeros = 0;
  }

  if(consecutiveZeros == 4) {
    return true; 
  }
}