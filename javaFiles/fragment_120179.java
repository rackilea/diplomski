boolean duplicates = false;
for (i = 0; i < arrayList.length - 1; i++) {
    for (j = i + 1; j < arrayList.length; j++) {
        if (arrayList[i] == arrayList[j]) {
            duplicates = true; // <-- Add this.
            System.out.println("Duplicate number: " + arrayList[i]);
            System.out.println("Duplicate number's index: " + j);
            break;
        }
    }
}
if (!duplicates) {
    System.out.println("no duplicates");
}