Iterator<IntWritable> it = getIterator();
List<IntWritable> cache = new ArrayList<IntWritable>();

// first loop and caching
while (it.hasNext()) {
   IntWritable value = it.next();
   doSomethingWithValue();
   cache.add(value);
}

// second loop
for(IntWritable value:cache) {
   doSomethingElseThatCantBeDoneInFirstLoop(value);
}