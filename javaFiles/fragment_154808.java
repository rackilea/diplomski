X sums = inputList.stream()
                  .reduce(new X(0,0,0),
                          (x,e) -> new X(x.getSumA()+e.getA(),
                                         x.getSumB()+e.getB(),
                                         x.getSumC()+e.getC()),
                          (x1,x2) -> new X(x1.getSumA()+x2.getSumA(),
                                           x1.getSumB()+x2.getSumB(),
                                           x1.getSumC()+x2.getSumC()));