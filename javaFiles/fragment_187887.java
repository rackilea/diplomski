List<Out> list = Stream.of(a).flatMap(aa -> 
  aa.parB.stream().flatMap(bb -> 
    bb.parE.stream().map(cc -> 
      new Out(aa.parA, bb.parC, bb.parD, cc.parF, cc.parG, cc.parH, cc.parJ))
  )
).collect(Collectors.toList());