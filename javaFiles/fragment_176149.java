List<Integer>ints = Arrays.asList(1,2,3);
assert sum(ints) == 6.0;
List<Double>doubles = Arrays.asList(2.78,3.14);
assert sum(doubles) == 5.92;
List<Number>nums = Arrays.<Number>asList(1,2,2.78,3.14);
assert sum(nums) == 8.92;