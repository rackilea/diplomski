List<Integer> startCodonIndices = new ArrayList<Integer>();
int index;
for (int i=0; i+3<dnax.length(); i++) {
    index = indexOf("AUG", i);
    startCodonIndices.add(index);
}