String temp=country[i];

  country[i]=country[i+1];
  country[i+1]=temp;

  temp=capital[i];
  capital[i]=capital[i+1];
  capital[i+1]=temp;

  temp=headOfState[i];
  headOfState[i]=headOfState[i+1];
  headOfState[i+1]=temp;