if (buildingCount > populationCount && foodCount > populationCount) {
    if (populationCount > 1000) {
        int randomNum = (int) ((ThreadLocalRandom.current().nextGaussian() / 2 + 0.5) * populationCount / 500);

        Data.main.setPopulationCount(populationCount + randomNum);
    } else {
        // Original for-loop here for populations less than 1000.
    }
}