int[] convertedValues = new int[10];
int max = convertedValues[0];

for (int i = 1; i < convertedValues.length; i++) {
    if (convertedValues[i] > max) {
        max = convertedValues[i];
    }
}