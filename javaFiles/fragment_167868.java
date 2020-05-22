IntStream.range(0, 10).parallel().boxed()
         .filter(i -> i >= 3 && i < 7)
         .collect(ArrayList::new, List::add, (l1,l2)->{
             System.out.println(l1.size()+" + "+l2.size());
             l1.addAll(l2);
         });