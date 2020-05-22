for (int k = 0; k<A.length - 1; k++){
  dif = Math.abs(leftMax[k] - rightMax[k + 1]);
  if (dif>maxDif) {
    maxDif = dif;
  }
}