for (int i = a.length() - 1; i >= 0; i--){
  if (num1[i] + num2[i] >= 10){
    sum[i] = (num1[i]+num2[i]) - 10;
    **sum[i-1] = 1;**
  } else {
      sum[i] = num1[i] + num2[i];   
  }
}