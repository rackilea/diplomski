// The different results each "wheel" / "column" on the slot machine.
String[] results = { "cherry", "bell", "grape", "x" };

// Create a random result for each wheel.
String wheel1 = results[generator.nextInt(results.length)];
String wheel2 = results[generator.nextInt(results.length)];
String wheel3 = results[generator.nextInt(results.length)];