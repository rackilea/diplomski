...
int holder = scoresCopy[i];
int iDholder = iDCopy[i];
scoresCopy[i] = scoresCopy[x];
iDCopy[i] = iDCopy[x];
scoresCopy[x] = holder;
iDCopy[x] = iDholder;  
...