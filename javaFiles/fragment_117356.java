Map<String, Supplier<Runnable>> hmap = new HashMap<>();
hmap.put("ArrayVerrification", ArrayVerification::new);
hmap.put("DivideNumber", DivideNumber::new);
hmap.put("Hello", Hello::new);
hmap.put("Rectangle", Rectangle::new);
hmap.put("StringOperations", StringOperations::new);
hmap.put("Substring", Substring::new);
hmap.put("SumOfPrimeNumbers", SumOfPrimeNumbers::new);
hmap.put("Test", Test::new);

for (Map.Entry<String, Supplier<Runnable>> pair : hmap.entrySet()){
    if (pair.getKey().equals(extractClassNameFromComand)) {
        Supplier<Runnable> supplier = pair.getValue();
        Runnable obj = supplier.get(); // calls: new Xxx()
        obj.run();
    }
}