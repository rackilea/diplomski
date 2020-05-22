int[] a = {5,1,3,5,5}; 
    final int n=a.length;
    Map<Integer, List<Integer>> x = Arrays.stream(a).boxed().collect(Collectors.groupingBy(i->i));
    // System.out.println(x); // {1=[1], 3=[3], 5=[5, 5, 5]}
    x.forEach((k,v)->{
        if(v.size()>n/2) System.out.println(k); // Check whether you need > or >=
    });