System.out.println("Current list:");
    printList(arrayList);

    int[] zxcIndex = getIndex(arrayList, "zxc");
    System.out.println("\nIndex of xzc is: " + zxcIndex[0] + ", " + zxcIndex[1] + "\n");

    updateIndex(arrayList, zxcIndex, "lmnop");

    System.out.println("Modified list at index " + zxcIndex[0] + "," + zxcIndex[1] + " :");
    printList(arrayList);