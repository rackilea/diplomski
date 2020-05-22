List<Type> list = /* ArrayList */
Set<Type> toRemove = /* HashSet */
List<Type> copy = new ArrayList<Type>(list.size());
for(Type t: list)
  if(!toRemove.contains(t))
    copy.add(t);
list = copy;