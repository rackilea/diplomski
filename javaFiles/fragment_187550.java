for(int n = 0; n < numtrials; n++)
        {
            x = Math.random();
            y = Math.random();

            double radius = (Math.pow(x, 2) + Math.pow(y,2));

            if(radius <= 1)
                trial[n] = trial[n] / numtrials * 4;                                  

        }