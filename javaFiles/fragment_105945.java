m(abc, Set.class);
        ^
  required: Map<String,T>,Class<T>
  found: Map<String,Set<String>>,Class<Set>
  reason: inferred type does not conform to equality constraint(s)
    inferred: Set
    equality constraints(s): Set,Set<String>
  where T is a type-variable:
    T extends Object declared in method <T>m(Map<String,T>,Class<T>)