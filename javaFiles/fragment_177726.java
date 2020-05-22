List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9);
int nInts = ints.size();
List<Long> longs = new ArrayList<Long>(nInts);
for (int i=0;i<nInts;++i) {
    longs.add(ints.get(i).longValue());
}