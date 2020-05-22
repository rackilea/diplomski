float totalAlpha = 0;
for(ColorStorage colorStorage : colorVectorsWithInfectionStrength)
{
    totalRed += (colorStorage.getRed() * colorStorage.getAlpha());
    totalBlue += (colorStorage.getBlue() * colorStorage.getAlpha());
    totalGreen += (colorStorage.getGreen() * colorStorage.getAlpha());
    totalAlpha += colorStorage.getAlpha();
}

totalRed /= totalAlpha;
totalBlue /= totalAlpha;
totalGreen /= totalAlpha;