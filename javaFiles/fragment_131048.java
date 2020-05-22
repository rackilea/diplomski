enum WeightClass { LOW, MEDIUM, HIGH };

public WeightClass determineWeightClass(int weight)
{
    return (weight < 16) 
        ? WeightClass.LOW 
        : (weight <= 48 
            ? WeightClass.MEDIUM 
            : WeightClass.HIGH);
}