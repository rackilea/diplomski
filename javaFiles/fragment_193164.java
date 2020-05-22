// Main Data List 
List<String> mainDataList = new ArrayList<>();
    mainDataList.add("A $0; B $0; C $0; D $0");
    mainDataList.add("B $5.8M; A $24.8M");
    mainDataList.add("A $9k; B $20k");
    mainDataList.add("A TBD; B TBD");
    mainDataList.add("C $36k; est. A $36k");
    mainDataList.add("A TBD; B TBD");
    mainDataList.add("D TBD; B TBD");
    mainDataList.add("D $1.1m; B $3m");
    mainDataList.add("A $3.86m; D $7.08m");
    mainDataList.add("C TBD; B TBD");

// Declare Lists for each Item (A to D) Value
List<String> itemListA = new ArrayList<>();
List<String> itemListB = new ArrayList<>();
List<String> itemListC = new ArrayList<>();
List<String> itemListD = new ArrayList<>();
boolean aHit, bHit, cHit, dHit;  // Flags

for (int i = 0; i < mainDataList.size(); i++) {
    aHit = false; bHit = false; 
    cHit = false; dHit = false;
    // RegEx "\\s+" is used below. It means one or more spaces.
    // Split the current Main Data List element string
    String[] tmpString = mainDataList.get(i).trim().split(";\\s+");
    // Iterate through the created array from the Main Data List element split.
    for (int j = 0; j < tmpString.length; j++) {
        // Split each Item element to Item and Value
        String[] data = tmpString[j].replaceAll("est.\\s+", "").split("\\s+");
        // Is it Item A
        if (data[0].equalsIgnoreCase("a")) {
            itemListA.add(data[1]);
            aHit = true;
        }
        // Is it Item B
        else if (data[0].equalsIgnoreCase("b")) {
            itemListB.add(data[1]);
            bHit = true;
        }
        // Is it Item C
        else if (data[0].equalsIgnoreCase("c")) {
            itemListC.add(data[1]);
            cHit = true;
        }
        // Is it Item D
        else if (data[0].equalsIgnoreCase("d")) {
            itemListD.add(data[1]);
            dHit = true;
        }
    }
    // Were all items hit in this current iteration
    // of the Main Data List.
    if (!aHit) { itemListA.add("$0"); }     // If no A in line add 0 to A list
    if (!bHit) { itemListB.add("$0"); }     // If no B in line add 0 to B list
    if (!cHit) { itemListC.add("$0"); }     // If no C in line add 0 to C list
    if (!dHit) { itemListD.add("$0"); }     // If no D in line add 0 to D list
}

// Display the Lists in Console....
// Since all Lists will be the same size we
// can use one loop.
System.out.println("\nList A\t\tList B\t\tList C\t\tList D");
System.out.println("======\t\t======\t\t======\t\t======");
for (int i = 0; i < itemListA.size(); i++) {
    System.out.print(itemListA.get(i)+"\t\t" + itemListB.get(i)+"\t\t" + 
            itemListC.get(i)+"\t\t" + itemListD.get(i));
    System.out.println("");
}