Class [] domains = { Integer.class, Double.class, String.class };
String [] stringValues = { "12", "31.4", "dog" };
Comparable [] comparableObjects = { null, null, null };

for (int i = 0; i < domains.length; i++) {
    Constructor con = domains[i].getConstructor(String.class);
    comparableObjects[i] = (Comparable) con.newInstance(stringValues[i]);
    System.out.println(comparableObjects[i]);
}