ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
     ArrayList<Integer> inner ;
        for (int i = 1; i <= 2; i++) {
            inner = new ArrayList<Integer>(); //each time new ArrayList<Integer> Need to Create. 
           for (int j = 1; j <= i*3; j++) {

               inner.add(j);
        }
          outer.add(inner);
      }
System.out.println(outer);