int m=Integer.parseInt(JOptionPane.showInputDialog("Enter index"));       
 //int values; dont need this
 int num [] = new int [m]; //num is initialised with length entered by the user

 //int max = num[0]; no need
 //int min = num[0]; no need
 for (int i=0;i<num.length;i++)      
 {                          
  num[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter value"));   
  System.out.println(num[i]);      

 }
Arrays.sort(num); //this will sort your array in ascending order: smallest number will be at the 0th index and largest will be at the last index                                    
System.out.println("Largest Number in a given array is : " + num[num.length-1]);
System.out.println("Smallest Number in a given array is : " + num[0]);