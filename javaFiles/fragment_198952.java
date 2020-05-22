private String interpretDiff(float diffValue) 
{
    if (diffValue < 100) 
        return "Eat more";
    return "Eat less";
}