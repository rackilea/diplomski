for(int k = 1; k < population.length; k++)
    {
        gtDiff = population[k] - population[k-1];

        if(gtDiff > highest)
        {
            year1 = 1950 + k;
            highest = gtDiff;
        }

    }