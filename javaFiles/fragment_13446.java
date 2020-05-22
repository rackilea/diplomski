// Negative number and 0
System.out.println(getInventorySize(-1));  // 9
System.out.println(getInventorySize(0));   // 9

// max <= 9
System.out.println(getInventorySize(5));   // 9
System.out.println(getInventorySize(9));   // 9

// some middle case 
System.out.println(getInventorySize(43));  // 45

// max >= 54
System.out.println(getInventorySize(54));  // 54
System.out.println(getInventorySize(55));  // 54