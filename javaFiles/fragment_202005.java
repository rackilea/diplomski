do {
    tryToGenerate++
    value = generateRandom();
    boolean unique = isUniqueValue(value);
  } while (!unique);
distributionSummary.record(tryToGenerate); // Add this