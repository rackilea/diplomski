if (Roman2[i]=='I'){
   Roman3[i]=1;
 } else if (Roman2[i]=='V'){
   Roman3[i]=5;
   if (i>0 && Roman2[i-1]=='I') { // check for IV
     Roman3[i]=4;
     Roman3[i-1]=0;
   }
 } else if (Roman2[i]=='X'){
   Roman3[i]=10;
 } else if (Roman2[i]=='L'){
   Roman3[i]=50;
 } else if (Roman2[i]=='C'){
   Roman3[i]=100;
 } else if (Roman2[i]=='M'){
   Roman3[i]=1000;
 }