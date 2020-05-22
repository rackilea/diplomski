for (int k = 0; k<A.length; k++){
  dif = Math.abs(leftMax[k] - rightMax[k]);
  if (dif>maxDif) {
    maxDif = dif;
  }
}