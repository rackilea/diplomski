List<Integer>ints = new ArrayList<Integer>();
count(ints, 5);
assert ints.toString().equals("[0, 1, 2, 3, 4]");
List<Number>nums = new ArrayList<Number>();
count(nums, 5); nums.add(5.0);
assert nums.toString().equals("[0, 1, 2, 3, 4, 5.0]");
List<Object>objs = new ArrayList<Object>();
count(objs, 5); objs.add("five");
assert objs.toString().equals("[0, 1, 2, 3, 4, five]");