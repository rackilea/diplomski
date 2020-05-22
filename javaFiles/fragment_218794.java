public ProvinceTerritory getHighestPopulation() {
    ProvinceTerritory max = null;
    for (ProvinceTerritory pt3 : provinces)
        if (max == null || pt3.getPopulation() > max.getPopulation())
            max = pt3;
    return max;
}