List<List<Integer>> collection = new ArrayList<List<Integer>>();
//Some initialization to get to this: [[1,0],[2,0],[3,3],[1,0,0]]
//The [1,0] list can be retrieved by the index 0
List<Integer> list = collection.get(0);
//Then you can do the same thing on that list to get the first value 
Integer integer = list.get(0); //This will be 1