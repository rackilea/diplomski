grade=first*.2+second*.2+third*.2+fourth*.4;                                                
NumberFormat formatter = new DecimalFormat("#.##");
String grado=formatter.format(grade);   
//Frame2 s2= new Frame2();

luanch(); // here

JTextField lblgrade = new JTextField(grado);