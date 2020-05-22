for(int g = 0;g < 5;g++){
   Pos[g] = new PVector(float(Data[g+1]),float(Data[g+6]));
   Vel[g] = new PVector(float(Data[g+12]),float(Data[g+17]));
   Mass[g] = float(Data[g+23]);
   Dir[g] = new PVector(0,0);
   Acc[g] = new PVector(0,0);
   Dist[g] = new PVector(0,0);
 }