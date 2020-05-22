Map<String, List<A>> input;
input.values().stream()
     .flatMap(Collection::stream)
     .map(a -> a.getListB()) // extract list B from A
     .flatMap(Collection::stream) // Here you get all B instances
     .collect(
         toMap(
            b -> b.getD().getF(), b -> b.getC().getE(), 
            (e1, e2) -> ??? // Here you should define your own merge function if there are two B instances has same F values
          )
     );