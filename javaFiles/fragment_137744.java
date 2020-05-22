for (Letter letter : letterNew) {
    updatedCountList = letter.getWeight();
    for (int i = 0; i < updatedWeightList.size(); i++) {
        countWeight += updatedCountList.get(i);
    }
    countWeightUpdated += countWeight;
    countWeight = 0; //THIS IS THE FIX
    if (countWeightUpdated >= r) {
        return letter;
    }
}