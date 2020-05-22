SensorManager.getRotationMatrix(R, I, accel, m);
m[0]=Math.round(m[0]);//X
m[1]=Math.round(m[1]);//Y
m[2]=Math.round(m[2]);//Z
v[0]=Math.round((m[0]*R[0] )+(m[1]*R[1])+(m[2]*R[2]));
v[1]=Math.round((m[0]*R[3] )+(m[1]*R[4])+(m[2]*R[5]));
v[2]=Math.round((m[0]*R[6] )+(m[1]*R[7])+(m[2]*R[8]));