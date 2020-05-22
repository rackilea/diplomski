public static double sd (ArrayList<Integer> table)
{
    // Step 1: 
    double mean = mean(table);
    double temp = 0;

    for (int i = 0; i < table.size(); i++)
    {
        int val = table.get(i);

        // Step 2:
        double squrDiffToMean = Math.pow(val - mean, 2);

        // Step 3:
        temp += squrDiffToMean;
    }

    // Step 4:
    double meanOfDiffs = (double) temp / (double) (table.size());

    // Step 5:
    return Math.sqrt(meanOfDiffs);
}