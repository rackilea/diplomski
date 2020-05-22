Set<Float> seen = new HashSet<Float>();
List<Integer> del = new List<Integer>();
for (int i = 0 ; i != vectorA.size() ; i++) {
    if (seen.add(vectorA[i])) {
        del.add(i);
    }
}
for (int i = del.size()-1 ; i >= 0 ; i--) {
    vectorA.remove(del[i]);
    vectorB.remove(del[i]);
    vectorC.remove(del[i]);
}