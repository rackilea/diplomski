Set<Integer> generated = new LinkedHashSet<Integer>();
// Prevent repeat
while (generated.size() < numtogen) {
    generated.add(rand.nextInt(100));
}
List<Integer> list = new ArrayList<Integer>(generated);