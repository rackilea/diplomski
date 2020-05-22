// Given
Set<Vector> mySet;
int reductionFactor = 200; // eg sample 0.5% of elements

List<Vector> list = new ArrayList<>(mySet);
Collections.sort(list, new Comparator<Vector> {
    public int compare(Vector o1, Vector o2) {
        // however you compare "strength"
    }         
});
List<Vector> randomSample = new ArrayList<>(list.size() / reductionFactor );
for (int i = 0; i < list.size(); i += reductionFactor)
    randomSample.add(list.get(i);