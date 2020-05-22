// Write each value in a collection to standard output on a separate line:

// C# - LINQ
myCollection.ForEach( x => Console.WriteLine(x) );
// Java - stream
myCollection.stream().forEach( x -> System.out.println(x) );

// Sum all the values in a (potentially large) collection, using parallelism
// if possible:

// C# - PLINQ
int sum = myCollection.AsParallel().Aggregate( (x, y) => x + y );
// Java - parallel stream
int sum = myCollection.stream().parallel().reduce( (x, y) -> x + y );