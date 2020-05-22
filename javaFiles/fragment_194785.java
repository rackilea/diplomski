Set<Type> symmetricDiff = new HashSet<Type>(set1);
symmetricDiff.addAll(set2);
// symmetricDiff now contains the union
Set<Type> tmp = new HashSet<Type>(set1);
tmp.retainAll(set2);
// tmp now contains the intersection
symmetricDiff.removeAll(tmp);
// union minus intersection equals symmetric-difference