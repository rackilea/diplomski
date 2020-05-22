ArrayList<Integer> nfit = new ArrayList<Integer>();
ArrayList<Integer> nfit_copy = new ArrayList<Integer>(nfit);

// Fill nfit 

  nfit.add(3);
  nfit.add(5);
  nfit.add(5);
  nfit.add(3);
  nfit.add(3);


  nfit_copy = (ArrayList<Integer>) nfit.clone();


  Collections.sort(nfit);

  int[] ind = new int[nfit.size()];

  for (int n = 0; n < nfit.size(); n++) {
         ind[n] = nfit_copy.indexOf(nfit.get(n));
         nfit_copy.set(nfit_copy.indexOf(nfit.get(n)), null);
   }
   for (int i = 0; i < ind.length; i++) {
         int j = ind[i];
         System.out.println(j);
    }