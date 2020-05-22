public boolean isAnyMatch(List<State> states, State other){   
  return states.stream()
               .anyMatch(s -> s.getA() == other.getA() && 
                         s.getB() == other.getB()  && 
                         s.getC() == other.getC() )
}


System.out.println(isAnyMatch(nodes, new State(12,0,0));