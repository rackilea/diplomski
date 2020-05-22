trans = new ArrayList<List<Transition>>(5);
for (j = 0; j <5; j++) {
   trans.add(new ArrayList<Transition>()); 
}
ArrayList<Transition> t = new ArrayList<Transition>(5);
for (j = 0; j <5; j++)
    trans.get(j).addAll(t); // <- out of bounds