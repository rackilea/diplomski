cost = getMinC(n+1, i+x-demand[n]) + storagecost * (i+x-demand[n]);
        if(x!=0) cost += fixc + varc * x;
        if(cost< min) {
            min = cost;
            bestx = x;
        }