if (method.isConcrete()) {

     List<Unit> instructionList = new ArrayList<>();

     Body b = method.retrieveActiveBody();
     DirectedGraph g = new ExceptionalUnitGraph(b);
     Iterator gitr = g.iterator();
     while (gitr.hasNext()) {
          Unit unit = (Unit) gitr.next();
          instructionList.add(unit);
     }
  }