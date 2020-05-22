double value = 0;
try {
  System.out.println();
  System.out.println("Value: ");
  value = sc.nextDouble();sc.nextLine();
  exec.ds.push(value);
} catch (Exception e1) {
  System.out.println(e1+ "You entered:  " + value + ": You must enter a number");                            
}