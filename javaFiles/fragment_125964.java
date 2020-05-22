// x*y = a 
IntVar a = VF.bounded("x*y",-25,25,solver);
solver.post(ICF.times(x,y,a); 
// a+z+t=10
IntVar cst = VF.fixed(10,solver);
solver.post(ICF.sum(new IntVar[]{a,z,t},cst));