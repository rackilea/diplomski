for (int x=0,y=0,z=0; x < end.length ; z++) {

              if(z==col_m1) {z=0;y++;}                
              if(y==end[x].length){y=0;x++;}
              end[x][y] += m1[x][z]*m2[z][y]; 
         }
    }