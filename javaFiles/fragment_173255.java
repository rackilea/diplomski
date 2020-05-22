String strings[][] = new String[][] {
     {"tiger", "elephant", "dog", "fish", "cat", "jaguar"},
     {"lion", "human", "manatee", "cow", "sphinx", "cougar"}
};

for (String[] line : strings) {
    System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s\n", 
        line[0], line[1], line[2], line[3], line[4], line[5]);
}