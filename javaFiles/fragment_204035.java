abstract class Super<S extends Super<S>> {
   abstract void process(S s);
}

class SubA extends Super<SubA> {
   void process(SubA s){ /* do something */ }
}

class SubB extends Super<SubB> {
   void process(SubB s){ /* do something */ }
}