sol = getMinC(n+1, i+x-demand[n]) + storagecost * (i+x-demand[n]);
        if(x!=0) cost += fixc + varc * x;
       if ( sol.min< minsol.min) {
            minsol.min = sol.min;
            minsol.decision=malloc (n, sizeof (int));
            minsol.decision [0]=x;
            // Copy content of sol.decision into minsol.decision starting at index 1

        }

  ...
  ...
  return minsol;