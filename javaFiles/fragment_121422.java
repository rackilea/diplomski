// Instead of 5 variables I created an array to store data
BigDecimal[] classTotal = new BigDecimal[5];
String line;
while ((line = bufferedReader.readLine()) != null) {
    String[] lineSplit = line.split("\\s+");
    // Class1 9.30 7.44 5.32 3.33 would become
    // [Class1, 9.30, 7.44, 5.32, 3.33]
    String name = lineSplit[0];
    switch (name) {
    case "Class1":
        classTotal[0] = getSum(lineSplit);
        break;
    case "Class2":
        classTotal[1] = getSum(lineSplit);
        break;
    case "Class3":
        classTotal[2] = getSum(lineSplit);
        break;
    case "Class4":
        classTotal[3] = getSum(lineSplit);
        break;
    case "Class5":
        classTotal[4] = getSum(lineSplit);
        break;

    }
}
bufferedReader.close();
for (int i = 0; i < classTotal.length; i++) {
    System.out.println("Class " + (i + 1) + " : " + classTotal[i]);
}

public static BigDecimal getSum(String[] line) {
    BigDecimal sum = new BigDecimal(0);
    // Iterating from index 1 because 0 index contains name
    for (int i = 1; i < line.length; i++) {
        BigDecimal valueBigDecimal = new BigDecimal(line[i]);
        sum = sum.add(valueBigDecimal);
    }
    return sum;
}