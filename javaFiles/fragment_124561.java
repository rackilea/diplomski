// initialize the List with 500 random values between 1 and 200
// you'll probably supply your existing lists instead
final Random rand = new Random();
final List<Integer> list = new ArrayList<Integer>();
for(int i = 0; i < 500; i++){
    list.add(rand.nextInt(200)+1);
}

// create a multiset
final Multiset<Integer> multiset = TreeMultiset.create(list);

// create 10 partitions of entries
// (each element value may appear multiple times in the multiset
// but only once per partition)
final Iterable<List<Integer>> partitions =
    Iterables.partition(
        multiset.elementSet(),
        // other than aioobe, I create the partition size from
        // the number of unique entries, accounting for gaps in the list
        multiset.elementSet().size() / 9
    );

int partitionIndex = 0;
for(final List<Integer> partition : partitions){

    // count the items in this partition
    int count = 0;
    for(final Integer item : partition){
        count += multiset.count(item);
    }
    System.out.println("Partition " + ++partitionIndex + " contains "
            + count + " items (" + partition.size() + " unique) from "
            + partition.get(0) + " to "
            + partition.get(partition.size() - 1));
}