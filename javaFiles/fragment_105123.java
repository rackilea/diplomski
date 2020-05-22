if (A.size() != B.size()) {
    System.out.println("Different sizes :(");
}
for (Integer key: B.keySet()) {
    if (A.get(key) != null && A.get(key).equals(B.get(key))) {
        correctValuesCounter++;
    }
}
System.out.printf("Correct values counter: %d%n", correctValuesCounter);