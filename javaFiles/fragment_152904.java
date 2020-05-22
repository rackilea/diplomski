for(int m = 1; m < population.length; m++)
    {
        lwDiff = population[m] - population[m-1];
        if(lwDiff < lowest)
        {
            year2 = 1950 + m;
            lowest = lwDiff;
        }
    }