System.out.println("1. Enter Student ID: ");
numID = sc.nextInt();
sc.nextLine();
Set<Integer> ids = new HashSet<>();
while (!ids.add(numID)) { // add returns false if numID is already in the Set
    System.out.println("The Student ID: " +numID+ " already exist.\nEnter New Student ID: ");
    numID = sc.nextInt();
    sc.nextLine();
}
...