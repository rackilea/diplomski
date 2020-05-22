System.out.println("Lowest total dollar item: ");
Integer largestQuantityMainVariable = getLargestQuantityItem(Quantities);
System.out.println("Largest quantity : " + largestQuantityMainVariable);

int index;
for (int i = 0; i < Quantities.size(); i++) {
    if (Quantities.get(i) != null && Quantities.get(i).equals(largestQuantityMainVariable)) {
        index = i;
        break;
    }
}

System.out.println("Largest quantity item : " + Titles.get(index));