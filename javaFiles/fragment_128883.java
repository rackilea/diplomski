for (int i=0; i<v.size (); i++) {  
  IVec [] vert=v.get(i); 
  for (int j=0; j<vert.length/2; j++) {
    IVec temp = vert[j];
    vert[j]=vert[vert.length -1 - j];
    vert[vert.length - 1 - j] = temp;
  }
}