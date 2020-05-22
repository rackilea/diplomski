int noc = Integer.valueOf(JOptionPane.showInputDialog("Enter # of cycles: "));
String a = JOptionPane.showInputDialog("Enter # of footsteps."); 
int z = Integer.valueOf(a);
int sum = 0;
double avg = 0.0;

for(int i=0;i<noc;i++) {
   sum+= randomWalk(z);
}
avg=(double)sum/noc;
System.out.println("the average distance walked in "+ noc + "cycles is "+avg);