if(y==0){
   vmin[x]=Math.min(x+radius+1,wm);
   vmax[x]=Math.max(x-radius,0);
  } 

  p1=pix[yw+vmin[x]];
  p2=pix[yw+vmax[x]];